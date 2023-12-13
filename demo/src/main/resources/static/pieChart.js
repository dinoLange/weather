class PieChart extends HTMLElement {
  // The browser calls this method when the element is
  // added to the DOM.

  columns
  rows

  static get observedAttributes() {
    return ['columns', 'rows'];
  }

  attributeChangedCallback(name, oldValue, newValue) {
    // Called when one of the observed attributes changes
    if (name === 'columns') {
      this.columns = this.getAttribute('columns');
    }
    if (name === 'rows') {
      this.rows = eval(this.getAttribute('rows'));
    }
  }

  connectedCallback() {

    google.charts.load('current', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(() => drawChart(this, this.columns, this.rows));


    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart(element, columns, rows) {
      // Create the data table.

      var data = new google.visualization.DataTable();

      var columnArray = columns.split(",")
      for(let index in columnArray) {
        data.addColumn(columnArray[index].split(":")[0].trim(), columnArray[index].split(":")[1].trim())
      }
      data.addRows(rows);

      // Set chart options
      var options = {'title':'How Much Pizza I Ate Last Night',
        'width':400,
        'height':300};

      // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.PieChart(element);
      chart.draw(data, options);
    }

  }
}

// Register the CurrentDate component using the tag name <current-date>.
customElements.define('pie-chart', PieChart);