$(document).ready(function() {
    console.log('Document ready, jQuery version:', $.fn.jquery);
    console.log('Script.js loaded');
    if (typeof d3 === 'undefined') {
        console.error('D3.js is not loaded. Check CDN: https://d3js.org/d3.v7.min.js');
        alert('Failed to load D3.js. Please refresh or check your network.');
        return;
    }
    if (typeof CanvasJS === 'undefined') {
        console.error('CanvasJS is not loaded. Check CDN: https://canvasjs.com/assets/script/canvasjs.stock.min.js');
        alert('Failed to load CanvasJS. Please refresh or check your network.');
        return;
    }

    const heatmapContainer = $('#heatmap-container');
    const candlestickContainer = $('#candlestick-container');
    const treemapDiv = d3.select('#treemap');
    const tooltip = d3.select('#tooltip');

    if (treemapDiv.empty()) {
        console.error('Treemap div not found in DOM');
        alert('Treemap container not found');
        return;
    }

    console.log('Treemap div dimensions:', {
        width: treemapDiv.node().clientWidth,
        height: treemapDiv.node().clientHeight,
        display: treemapDiv.style('display'),
        visibility: treemapDiv.style('visibility')
    });

    // Define color scale for TradingView-like gradient
    const colorScale = d3.scaleLinear()
        .domain([-5, -1.5, -0.2, 0.2, 1.5, 5])
        .range(['#991F2A', '#F23745', '#F77C80', '#42BD7F', '#0A9950', '#056636']);

    // Stock names and icons
    const stockNames = {
        'AAPL': 'Apple Inc.', 'MSFT': 'Microsoft Corporation', 'GOOGL': 'Alphabet Inc.',
        'AMZN': 'Amazon.com Inc.', 'TSLA': 'Tesla Inc.', 'NVDA': 'NVIDIA Corporation',
        'JPM': 'JPMorgan Chase & Co.', 'V': 'Visa Inc.', 'WMT': 'Walmart Inc.',
        'JNJ': 'Johnson & Johnson', 'PG': 'Procter & Gamble Co.', 'DIS': 'The Walt Disney Company',
        'NFLX': 'Netflix Inc.', 'XOM': 'Exxon Mobil Corporation', 'BAC': 'Bank of America Corporation'
    };
    const stockIcons = {
        'AAPL': '/img/AAPL.png', 'MSFT': '/img/MSFT.png', 'GOOGL': '/img/GOOGL.png',
        'AMZN': '/img/AMZN.png', 'TSLA': '/img/TSLA.png', 'NVDA': '/img/NVDA.png',
        'JPM': '/img/JPM.png', 'V': '/img/V.png', 'WMT': '/img/WMT.png',
        'JNJ': '/img/JNJ.png', 'PG': '/img/PG.png', 'DIS': '/img/DIS.png',
        'NFLX': '/img/NFLX.png', 'XOM': '/img/XOM.png', 'BAC': '/img/BAC.png'
    };

    function renderTreemap(data) {
        console.log('Attempting to render treemap with data:', data);
        if (!data || !Array.isArray(data) || data.length === 0) {
            console.error('Invalid or empty treemap data:', data);
            alert('No valid stock data to display');
            return;
        }

        const isValidData = data.every(item => 
            item && item.symbol && typeof item.currentPrice === 'number' && typeof item.percentChange === 'number'
        );
        if (!isValidData) {
            console.error('Data validation failed. Expected format: { symbol: string, currentPrice: number, percentChange: number }', data);
            alert('Invalid stock data format');
            return;
        }

        treemapDiv.selectAll('*').remove();
        console.log('Cleared previous treemap');

        const width = treemapDiv.node().clientWidth || window.innerWidth;
        const height = treemapDiv.node().clientHeight || window.innerHeight;
        console.log('Treemap dimensions set:', { width, height });

        const svg = treemapDiv.append('svg')
            .attr('width', width)
            .attr('height', height);
        console.log('Treemap SVG created:', svg.node());

        const treemap = d3.treemap()
            .size([width, height])
            .padding(4)
            .round(true);
        console.log('Treemap layout initialized');

        const root = d3.hierarchy({
            children: data.map(item => ({
                symbol: item.symbol,
                value: Math.abs(item.currentPrice),
                percentChange: item.percentChange,
                currentPrice: item.currentPrice
            }))
        })
        .sum(d => d.value)
        .sort((a, b) => b.value - a.value);
        console.log('Hierarchical data prepared:', root);

        treemap(root);
        console.log('Treemap computed');

        const cell = svg.selectAll('g')
            .data(root.leaves())
            .enter()
            .append('g')
            .attr('transform', d => `translate(${d.x0},${d.y0})`)
            .style('cursor', 'pointer')
            .on('click', (event, d) => {
                console.log('Clicked symbol:', d.data.symbol);
                fetchCandlestickData(d.data.symbol);
            })
            .on('mouseover', function(event, d) {
                const symbol = d.data.symbol;
                console.log('Hovering over:', symbol);
                tooltip.style('display', 'block')
                    .html(`
                        <img src="${stockIcons[symbol] || '/img/fallback.png'}" alt="${symbol}">
                        <strong>${stockNames[symbol] || symbol}</strong><br>
                        Price: $${d.data.currentPrice.toFixed(2)}<br>
                        Change: ${d.data.percentChange.toFixed(2)}%<br>
                        <div id="tooltip-chart" class="tooltip-chart"></div>
                    `)
                    .style('left', `${event.pageX + 10}px`)
                    .style('top', `${event.pageY - 10}px`);

                // Fetch and render small candlestick chart
                $.ajax({
                    url: `http://localhost:8081/ohlcdata?code=${symbol}`,
                    method: 'GET',
                    success: function(data) {
                        console.log('Tooltip candlestick data for ' + symbol + ':', data);
                        if (data && Array.isArray(data) && data.length > 0) {
                            const chart = new CanvasJS.Chart('tooltip-chart', {
                                backgroundColor: '#333333',
                                axisX: {
                                    labelFontColor: '#ffffff',
                                    lineColor: '#ffffff',
                                    tickColor: '#ffffff',
                                    labelFontSize: 10
                                },
                                axisY: {
                                    labelFontColor: '#ffffff',
                                    gridColor: '#555555',
                                    tickColor: '#ffffff',
                                    labelFontSize: 10
                                },
                                data: [{
                                    type: 'candlestick',
                                    risingColor: '#42BD7F',
                                    fallingColor: '#F23745',
                                    dataPoints: data.map(item => {
                                        const date = new Date(item.date);
                                        if (isNaN(date.getTime())) {
                                            console.error('Invalid tooltip date for ' + symbol + ':', item.date);
                                            return null;
                                        }
                                        return {
                                            x: date,
                                            y: [item.open, item.high, item.low, item.close]
                                        };
                                    }).filter(point => point !== null)
                                }]
                            });
                            chart.render();
                            console.log('Tooltip chart rendered for:', symbol);
                        }
                    },
                    error: function(err) {
                        console.error('Error fetching tooltip data for ' + symbol + ':', err);
                        tooltip.html(tooltip.html() + '<br>No historical data available');
                    }
                });
            })
            .on('mousemove', function(event) {
                tooltip.style('left', `${event.pageX + 10}px`)
                    .style('top', `${event.pageY - 10}px`);
            })
            .on('mouseout', function() {
                tooltip.style('display', 'none');
            });

        cell.append('rect')
            .attr('class', 'treemap-rect')
            .attr('width', d => d.x1 - d.x0)
            .attr('height', d => d.y1 - d.y0)
            .attr('fill', d => colorScale(d.data.percentChange));

        cell.each(function(d) {
            const g = d3.select(this);
            const cellWidth = d.x1 - d.x0;
            const cellHeight = d.y1 - d.y0;
            const fontSize = Math.min(cellWidth, cellHeight) * 0.05 + 8;
            const isLeftSide = d.x0 < width / 2; // Left side of treemap
            const iconSize = isLeftSide 
                ? Math.min(Math.min(cellWidth, cellHeight) * 0.3, 50) // 30% for left side, max 50px
                : Math.min(Math.min(cellWidth, cellHeight) * 0.2, 40); // 20% elsewhere, max 40px

            const centerY = cellHeight / 2;
            const hasImage = cellWidth > 40 && cellHeight > 40;

            const contentGroup = g.append('g')
                .attr('transform', `translate(${cellWidth / 2}, ${centerY})`);

            if (hasImage) {
                contentGroup.append('image')
                    .attr('class', 'treemap-image')
                    .attr('xlink:href', stockIcons[d.data.symbol] || '/img/fallback.png')
                    .attr('x', -iconSize / 2)
                    .attr('y', -iconSize - (fontSize * 1.1))
                    .attr('width', iconSize)
                    .attr('height', iconSize)
                    .on('error', function() {
                        d3.select(this).remove();
                    });
            }

            contentGroup.append('text')
                .attr('class', 'treemap-text')
                .attr('y', hasImage ? fontSize * 0.5 : 0)
                .style('font-size', `${fontSize}px`)
                .text(d => `${d.data.symbol}\n${d.data.percentChange.toFixed(2)}%`)
                .call(wrapText, cellWidth - 10);
        });

        function wrapText(text, width) {
            text.each(function() {
                const text = d3.select(this);
                const words = text.text().split('\n');
                text.text(null);
                let y = parseFloat(text.attr('y'));
                words.forEach((word, i) => {
                    text.append('tspan')
                        .attr('x', 0)
                        .attr('y', y + i * 1.1 * parseFloat(text.style('font-size')))
                        .attr('dy', '0.35em')
                        .text(word);
                });
            });
        }

        console.log('Treemap rendering complete');
    }

    function fetchCandlestickData(symbol) {
        console.log('Fetching candlestick data for:', symbol);
        $.ajax({
            url: `http://localhost:8081/ohlcdata?code=${symbol}`,
            method: 'GET',
            success: function(data) {
                console.log('Candlestick data received for ' + symbol + ':', data);
                renderCandlestick(data, symbol);
                heatmapContainer.hide();
                candlestickContainer.show();
            },
            error: function(err) {
                console.error('Error fetching candlestick data for ' + symbol + ':', err);
                alert('Failed to load candlestick data for ' + symbol);
            }
        });
    }

    function renderCandlestick(data, symbol) {
        console.log('Rendering candlestick for:', symbol, 'Data:', data);
        if (!data || !Array.isArray(data) || data.length === 0) {
            console.error('Invalid or empty candlestick data for ' + symbol + ':', data);
            alert('No valid candlestick data for ' + symbol);
            return;
        }

        const isValidCandlestickData = data.every(item => 
            item && item.date && typeof item.open === 'number' && 
            typeof item.high === 'number' && typeof item.low === 'number' && 
            typeof item.close === 'number'
        );
        if (!isValidCandlestickData) {
            console.error('Invalid candlestick data format for ' + symbol + ':', data);
            alert('Invalid candlestick data format for ' + symbol);
            return;
        }

        const candlestickDiv = document.getElementById('candlestick');
        candlestickDiv.innerHTML = ''; // Clear previous chart

        const chart = new CanvasJS.StockChart('candlestick', {
            backgroundColor: '#1A1A1A',
            charts: [{
                data: [{
                    type: 'candlestick',
                    risingColor: '#42BD7F',
                    fallingColor: '#F23745',
                    dataPoints: data.map(item => {
                        const date = new Date(item.date);
                        if (isNaN(date.getTime())) {
                            console.error('Invalid date for ' + symbol + ':', item.date);
                            return null;
                        }
                        return {
                            x: date,
                            y: [item.open, item.high, item.low, item.close]
                        };
                    }).filter(point => point !== null)
                }],
                axisX: {
                    labelFontColor: '#ffffff',
                    lineColor: '#ffffff',
                    tickColor: '#ffffff'
                },
                axisY: {
                    labelFontColor: '#ffffff',
                    gridColor: '#333333',
                    tickColor: '#ffffff'
                }
            }],
            navigator: {
                backgroundColor: '#1A1A1A',
                slider: {
                    minimum: new Date(data[0].date),
                    maximum: new Date(data[data.length - 1].date)
                },
                axisX: {
                    labelFontColor: '#ffffff',
                    lineColor: '#ffffff',
                    tickColor: '#ffffff'
                },
                axisY: {
                    labelFontColor: '#ffffff'
                }
            }
        });

        chart.render();
        console.log('Candlestick chart rendered for:', symbol);
    }

    $('#back-to-treemap').click(function() {
        candlestickContainer.hide();
        heatmapContainer.show();
        document.getElementById('candlestick').innerHTML = '';
        console.log('Returned to treemap');
    });

    function fetchAndRenderData() {
        console.log('Fetching stock data');
        $.ajax({
            url: 'http://localhost:8081/stockdata',
            method: 'GET',
            success: function(data) {
                console.log('Fetched stock data:', data);
                renderTreemap(data);
            },
            error: function(err) {
                console.error('Error fetching stock data:', err);
                alert('Failed to load stock data');
            }
        });
    }

    fetchAndRenderData();
    setInterval(fetchAndRenderData, 60000);
});