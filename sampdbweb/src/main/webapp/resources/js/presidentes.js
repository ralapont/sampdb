var pagina = 1;

$(document).ready(function() {
	var $url = '/sampdbweb/presidentjson';
	
	jQuery("#listPresident").jqGrid({ 
		url:$url, 
		reginal: "",
		mtype: 'GET', 
		datatype: "json", 
		colNames:['Id','Apellido', 'Nombre','Estado','Ciudad','F.Naf','F.Fac'], 
		colModel:[ 
			{name:'presidentId',index:'presidentId', width:55,   sortable:true,  search:true,  align:"left"}, 
			{name:'lastName',   index:'lastName',    width:90,   sortable:true,  search:true,  align:"left"}, 
			{name:'firstName',  index:'firstName',   width:100,  sortable:true,  search:true,  align:"left"}, 
			{name:'stateDesc',  index:'stateDesc',   width:80,   sortable:true,  search:true,  align:"left"}, 
			{name:'city',       index:'city',        width:80,   sortable:true,  search:false, align:"left"}, 
			{name:'birth',      index:'birth',       width:80,   sortable:true,  search:false, align:"left"}, 
			{name:'death',      index:'death',       width:150,  sortable:true,  search:false, align:"left"} 
		], 
		rowNum:10, rowList:[10,20,30], 
		pager: '#pagerPresident', 
		sortname: 'presidentId', 
		viewrecords: true, 
		sortorder: "desc", 
		caption:"Relación de Presidentes de USA",
        jsonReader : {
            root:       "content",
            page:       "number",
            total:      "totalPages",
            records:    "totalElements", 
            repeatitems: false,
           },    
	}); 

	jQuery("#listPresident").jqGrid(
		'navGrid',
		'#pagerPresident',
		{edit:false,add:false,del:false
	});	
	
    $("#listPresident").jqGrid('filterToolbar', {stringResult: true, searchOnEnter: false,
        defaultSearch: 'cn', ignoreCase: true});	
}); 

