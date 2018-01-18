


$('#form-conferencias').submit(function(e) { 
    e.preventDefault();
    
    tabela = document.getElementById('tabela-produtos');
    numeroLinhas = tabela.rows.length;    
    barras = document.getElementById("nome").value;
    
    document.getElementById("nome").select();
    
    console.log(barras+numeroLinhas);
    
    
    document.getElementById('tabela-produtos').deleteRow(1);
    
    
    
    
}); 


function removeLinha(linha) {
    var i=linha.parentNode.parentNode.rowIndex;
    document.getElementById('tabela-produtos').deleteRow(i);
  }  

