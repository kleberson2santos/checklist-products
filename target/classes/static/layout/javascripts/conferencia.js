


$('#form-conferencias').submit(function(e) { 
    e.preventDefault();
    
    tabela = document.getElementById('tabela-produtos');
    numeroLinhas = tabela.rows.length;    
    var barras = document.getElementById("nome").value;
    barras = barras.replace(/\s+/g, "");
    var linha;
    
    document.getElementById("nome").select();
    
    //console.log(barras+numeroLinhas);
    
    //for ( var i = 0; i < numeroLinhas; i++ )
   // {	
    //	if()
    	//console.log( tabela.rows[0].value);
   // }
    
    
    //document.getElementById('tabela-produtos').deleteRow(1);
    
    	mytable     = document.getElementsByTagName("table")[0];
    	mytablebody = mytable.getElementsByTagName("tbody")[0];
    for ( var i = 0; i < (numeroLinhas-2); i++ ){    
    	var myrow       = mytablebody.getElementsByTagName("tr")[i];
    	var mycel       = myrow.getElementsByTagName("td")[0];
    	var cell		= mycel.getElementsByTagName('a')[0].innerText;
    	
    	if(cell==barras){
    		linha=myrow;
    		mytablebody.deleteRow(i);
    		break;
    	}
    }
    
    
}); 


//function removeLinha(linha) {
//    var i=linha.parentNode.parentNode.rowIndex;
//    document.getElementById('tabela-produtos').deleteRow(i);
//  }  

