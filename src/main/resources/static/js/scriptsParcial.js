//--------------------------------------------------Tablas------------------------------------------------------
function mostrarTabla(tabla){
	var ruta;
	var mensaje;
	var rutaBtn;
	var extra;
	switch (tabla) {
		case 1:
			ruta="./cargarUsuario";
			mensaje="Editar usuario";
			rutaBtn = "./editarUsuario";
			extra="&tipo=1"
			break;
		case 2:
			ruta="./cargarclientes";
			mensaje="Editar materia";
			rutaBtn = "./editarMateria";
			extra=""
			break;
		case 3:
			ruta="./cargarCentrosEscolares";
			mensaje="Editar centro escolar";
			rutaBtn = "./editarCentroEscolar";
			extra=""
			break;
	}
	datosTabla(ruta, mensaje, rutaBtn, extra);
}

function datosTabla(tabla, mensaje, rutaBtn, extra){
	$(document).ready(function(){
		var table = $('#tabla').DataTable( {
			"ordering": false,
	        "processing": true,
	        "serverSide": true,
	        "ajax": tabla,
	        "language": {
	            "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
	        },
	        "pageLength": 5,
	        "columnDefs": [ {
	            "targets": 0,
	            "data": null,
	            "searchable": false,
	            "defaultContent": "<button class='btn btn-info' title='"+mensaje+"' id='i'><i class='fa fa-pencil-alt'></i></button>"
	        }]
	    });
		$('#tabla tbody').on( 'click', '#i', function () {
	        var data = table.row( $(this).parents('tr') ).data();
	        	location.href = './'+rutaBtn+'?id=' + data[0] + extra;
	    } );
	});
}

function datosTablaMateriaCursadas(){
	$(document).ready(function(){
		var val1 = document.getElementById("boton").value;
		var val2 = document.getElementById("boton2");
		
		val2.href = "/registrarMateriaCursada?id=" + val1;
		
		var table = $('#tabla').DataTable( {
			"dom": '<"top"l>rt<"bottom"p><"clear">',
			"ordering": false,
	        "processing": true,
	        "serverSide": true,
	        "ajax": "./cargarMateriasCursadas?id="+$('#boton').val(),
	        "language": {
	            "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
	        },
	        "pageLength": 5,
	        "columnDefs": [ {
	            "targets": 0,
	            "data": null,
	            "searchable": false,
	            "defaultContent": "<button class='btn btn-info' title='Editar Materia' id='i2'><i class='fa fa-pencil-alt'></i></button>"
	        }]
	    });
		$('#tabla tbody').on( 'click', '#i2', function () {
	        var data = table.row( $(this).parents('tr') ).data();
	        	location.href = './editarMateriaAlumno?id=' + val1 + "&id2="+data[0];
	    } );
	});
}

function datosTablaExpediente(){
	$(document).ready(function(){
		var table = $('#tablaClientes').DataTable( {
			"dom": '<"top"l>rt<"bottom"p><"clear">',
			"ordering": false,
	        "processing": true,
	        "serverSide": true,
	        "ajax": "./cargarEstudiantes?variable="+$('#boton').val()+"&criterio="+$('#boton2').val(),
	        "language": {
	            "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
	        },
	        "pageLength": 5,
	        "columnDefs": [ {
	            "targets": 0,
	            "data": null,
	            "searchable": false,
	            "defaultContent": "<button class='btn btn-info' title='Editar Alumno' id='i2' style='margin-right: 10px;'><i class='fas fa-search'></i></button><button class='btn btn-info' title='Materias cursadas' id='i'><i class='fa fa-pencil-alt'></i></button> "
	        }]
	    });
		$('#tablaClientes tbody').on( 'click', '#i2', function () {
	        var data = table.row( $(this).parents('tr') ).data();
	        	location.href = './editarEstudiante?id=' + data[0];
	    } );
		$('#tablaClientes tbody').on( 'click', '#i', function () {
	        var data = table.row( $(this).parents('tr') ).data();
	        	location.href = './materiasCursadas?id='+ data[0];
	    } );
	});
}

//--------------------------------------------------Otras funciones------------------------------------------------------

function combobox(bandera){
	$(document).ready(
			function() {
				$('#departamento').change(
						municipio
				)
				if(bandera == 1){
					$('#departamentoCE').change(
							municipio2
					)
					$('#municipioCE').change(
							centroEscolar
					)
				}
			}
	)
}

function municipio(){
	var pri = document.getElementById("departamento").value;
	$.ajax({
		type : "POST",
		"serverSide" : true,
		url : "./cargarMunicipios",
		data : {
			draw : pri
		},
		success : function(r) {
			$('#municipio').empty();
			$("<option/>").val(0).text(
					"Seleccione una opción").appendTo(
					"#municipio");
			$.each(r, 
					function(key, val) {
						$("<option/>").val(r[key][0])
								.text(r[key][1])
								.appendTo("#municipio");
					});
		},
		error : function(data) {
			alert('error');
		}
	})
}

function municipio2(){
	var pri = document.getElementById("departamentoCE").value;
	$.ajax({
		type : "POST",
		"serverSide" : true,
		url : "./cargarMunicipios",
		data : {
			draw : pri
		},
		success : function(r) {
			$('#municipioCE').empty();
			$('#centroE').empty();
			$("<option/>").val(0).text(
			"Seleccione una opción").appendTo(
			"#centroE");
			$("<option/>").val(0).text(
					"Seleccione una opción").appendTo(
					"#municipioCE");
			$.each(r, 
					function(key, val) {
						$("<option/>").val(r[key][0])
								.text(r[key][1])
								.appendTo("#municipioCE");
					});
		},
		error : function(data) {
			alert('error');
		}
	})
}

function centroEscolar(){
	var pri = document.getElementById("municipioCE").value;
	$.ajax({
		type: "POST",
		"serverSide": true,
		url: "./cargarCentroEscolar",
        data: { draw : pri },
		success:function(r){
			$('#centroE').empty();
			var select = document.getElementById("centroE");
			$("<option/>").val(0).text("Seleccione una opción").appendTo("#centroE");
			$.each(r, function(key, val) {
				$("<option/>").val(r[key][0]).text(r[key][1]).appendTo("#centroE");
		    });
		},
	    error: function(data) {
	        alert('error');
	      }
	})
}


function calcularEdad(fecha) {
    var hoy = new Date();
    var cumpleanos = new Date(fecha);
    var edad = hoy.getFullYear() - cumpleanos.getFullYear();
    var m = hoy.getMonth() - cumpleanos.getMonth();

    if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
        edad--;
    }

    return edad;
}

$('#fecha').change(function() {
	document.querySelector("#edad").value = calcularEdad(document.querySelector("#fecha").value);
});
