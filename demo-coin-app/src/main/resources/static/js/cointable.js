if (typeof jQuery === 'undefined') {
  console.error('jQuery is not loaded! Please check the script tag order or network.');
} else {
  $(document).ready(function () {
    console.log('jQuery and document ready!');

    const coinFilter = $('#coinFilter');
    const coinRows = $('.coinRow');

    coinFilter.on('input', function () {
      const filter = coinFilter.val().toUpperCase();
      coinRows.each(function () {
        const coinId = $(this).find('td:first-child').text().toUpperCase();
        if (coinId.indexOf(filter) > -1) {
          $(this).show();
        } else {
          $(this).hide();
        }
      });
    });

    setInterval(function () {
      console.log('Fetching updated data at', new Date().toLocaleTimeString('en-US', { timeZone: 'Asia/Hong_Kong' }));
      $.ajax({
        url: '/coinlist',
        type: 'GET',
        success: function (data) {
          console.log('Received data:', JSON.stringify(data, null, 2));
          if (!Array.isArray(data)) {
            console.error('Data is not an array:', data);
            return;
          }
          data.forEach(function (coin) {
            var row = $(`tr[data-coin-id='${coin.id}']`);
            if (row.length) {
              row.find('.last-updated').text(formatDate(coin.last_updated));
              row.find('td:nth-child(3)').text('$' + coin.current_price.toFixed(2));
              row.find('td:nth-child(5)').text('$' + coin.market_cap.toLocaleString());
              var priceClass = coin.price_change_percentage_24h > 0 ? 'up' : coin.price_change_percentage_24h < 0 ? 'down' : 'neutral';
              var priceChangeValue = Math.abs(coin.price_change_percentage_24h).toFixed(2) + '%';
              var priceChangeElement = row.find('.price-change');
              priceChangeElement.removeClass('up down neutral').addClass(priceClass);
              priceChangeElement.find('span').text(priceChangeValue); // Only update the percentage
            } else {
              console.warn(`No row found for coin ID: ${coin.id}`);
            }
          });
        },
        error: function (xhr, status, error) {
          console.error('AJAX Error:', status, error, xhr.responseText);
        },
      });
    }, 30000);

    function formatDate(lastUpdated) {
      var date = new Date(lastUpdated);
      var year = date.getFullYear();
      var month = ('0' + (date.getMonth() + 1)).slice(-2);
      var day = ('0' + date.getDate()).slice(-2);
      var hours = ('0' + date.getHours()).slice(-2);
      var minutes = ('0' + date.getMinutes()).slice(-2);
      var seconds = ('0' + date.getSeconds()).slice(-2);
      return `${year}-${month}-${day} ${hours}:${minutes}:${seconds} HKT`;
    }
  });
}