/**
 * Copyright (c) 2013, Sanket Bharaswadkar
 * All rights reserved.
 *
 * Licensed under the BSD, MIT, and GPL (your choice!) Licenses:
 *  BharasSc@mail.uc.edu
 *
 */
$(document).ready(function() {
	    // check name availability on focus lost
	    $('#name').blur(function() {
	        checkAvailability();
	    });
	});

	function checkAvailability() {
	    $.getJSON("account/availability", { name: $('#name').val() }, function(availability) {
	        if (availability.available) {
	            fieldValidated("name", { valid : true });
	        } else {
	            fieldValidated("name", { valid : false,
	                message : $('#name').val() + " is not available, try " + availability.suggestions });
	        }
	    });
	}
	
	/*changeFunc loads the KnightedDiv only when the knighted technology is selected from the dropdown;
	 * It is hidden earlier and not 'display: none;' It is because display has issues with 
	 the box size after it is made visible through the JavaScript;
	 */
	function changeFunc() {
		//document.getElementById('knightedDiv').style.display= 'none';
		var selectBox = document.getElementById("technology12");
		var selecValue = selectBox.options[selectBox.selectedIndex].value;
		if (selectBox.selectedIndex === 1) {
			document.getElementById('knightedDiv').style.visibility = 'visible';
		} else {
			document.getElementById('knightedDiv').style.visibility = 'hidden';
		}
	}
	
	
	/*ajaxPost for the projectStatusUpdateForm
	 * This will update the status of the Project
	 * In the controller method, an update query is executed*/
	
	// variable to hold request
	var request;
	// bind to the submit event of our form
	$("#projectStatusUpdateForm").submit(function(event){
	    // abort any pending request
	    if (request) {
	        request.abort();
	    }
	    // setup some local variables
	    var $form = $(this);
	    // let's select and cache all the fields
	    //var $inputs = $form.find("input, select, button, textarea");
	    // serialize the data in the form
	    var serializedData = $form.serialize();

	    // let's disable the inputs for the duration of the ajax request
	    //$inputs.prop("disabled", true);

	    // fire off the request to /form.php
	    request = $.ajax({
	        url: "updateStatus",
	        type: "post",
	        data: serializedData
	    });

	    // callback handler that will be called on success
	    request.done(function (response, textStatus, jqXHR){
	        // log a message to the console
	        console.log("Hooray, it worked!");
	    });

	    // callback handler that will be called on failure
	    request.fail(function (jqXHR, textStatus, errorThrown){
	        // log the error to the console
	        console.error(
	            "The following error occured: "+
	            textStatus, errorThrown
	        );
	    });

	    // callback handler that will be called regardless
	    // if the request failed or succeeded
	    request.always(function () {
	        // reenable the inputs
	        //$inputs.prop("disabled", false);
	        alert('Status updated successfully.');
	    });

	    // prevent default posting of form
	    event.preventDefault();
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*This is a function for Search as you Type (SayT) functionality
	 * The asynchronous call is made when at least 2 characters are entered 
	 * The list of employees matching the search criteria is fetched and cached
	 * Next time, when the same search term is entered, cached result is made available
	 * 
	 * */
	
	$(function() {
	    function split( val ) {
	      return val.split( /,\s*/ );
	    }
	    function extractLast( term ) {
	      return split( term ).pop();
	    }
	    var cache = {};
	    $( "#employees" )
	      // don't navigate away from the field on tab when selecting an item
	      .bind( "keydown", function( event ) {
	        if ( event.keyCode === $.ui.keyCode.TAB &&
	            $( this ).data( "ui-autocomplete" ).menu.active ) {
	          event.preventDefault();
	        }
	      })
	      .autocomplete({
	        source: function( request, response ) {
	        	var term = request.term;
	            if ( term in cache ) {
	              response( cache[ term ] );
	              return;
	            }
	            
	            var res = $.getJSON( "getEmployees", { term: extractLast( request.term ) }, response );
	            //Sanket - trying to filter the result set
	            response( $.ui.autocomplete.filter(
	            		res, extractLast( request.term ) ) );
	            //Sanket - Push the current search term in the cache as key and the result set as value
	            res.done(function(response) { cache[ term ] =response; });;
	        },
	        search: function() {
	          // custom minLength
	          var term = extractLast( this.value );
	          if ( term.length < 2 ) {
	            return false;
	          }
	        },
	        focus: function() {
	          // prevent value inserted on focus
	          return false;
	        },
	        select: function( event, ui ) {
	        	//trying to set the input@id="employees" tag with the 'key' i.e. employeeId of selected employee
	        	//document.getElementById("employees").setAttribute("value", this.key);
	        	
	          var terms = split( this.value );
	          // remove the current input
	          terms.pop();
	          // add the selected item
	          
	          terms.push( ui.item.value);
	          
	          // add placeholder to get the comma-and-space at the end
	          terms.push( "" );
	          this.value = terms.join( ", " );
	          return false;
	        }
	      });
	  });
	/*End of SayT function*/
	
	
	
	/*ajaxPost for the addEmployeeForm
	 * This will add the list of Employee to the Project
	 * In the controller method, an insert query is executed*/
	
	// variable to hold request
	var request;
	// bind to the submit event of our form
	$("#addEmployeeForm").submit(function(event){
	    // abort any pending request
	    if (request) {
	        request.abort();
	    }
	    // setup some local variables
	    var $form = $(this);
	    var $empList = document.getElementById('employees').value;
	    //Extracting only the employeeId from $empList
	    var re = /\D+/gi;
        var employeeIds = $empList.replace(re, ",");
	    
	    // let's select and cache all the fields
	    //var $inputs = $form.find("input, select, button, textarea");

	    // let's disable the inputs for the duration of the ajax request
	    //$inputs.prop("disabled", true);

	    // fire off the request to addEmployee
	    request = $.ajax({
	        url: "addEmployee",
	        type: "get",
	        data: "employeeIds="+employeeIds
	    });

	    // callback handler that will be called on success
	    request.done(function (response, textStatus, jqXHR){
	        // log a message to the console
	        console.log("Hooray, it worked!");
	    });

	    // callback handler that will be called on failure
	    request.fail(function (jqXHR, textStatus, errorThrown){
	        // log the error to the console
	        console.error(
	            "The following error occured: "+
	            textStatus, errorThrown
	        );
	    });

	    // callback handler that will be called regardless
	    // if the request failed or succeeded
	    request.always(function () {
	        // reenable the inputs
	        //$inputs.prop("disabled", false);
	        alert('Employee added successfully.');
	    });

	    // prevent default posting of form
	    event.preventDefault();
	});
	
	
	/* To highlight the search term in the autocomplete, we are monkey patching the _renderItem function */
	function monkeyPatchAutocomplete() {

	      // don't really need this, but in case I did, I could store it and chain
	      var oldFn = $.ui.autocomplete.prototype._renderItem;

	      $.ui.autocomplete.prototype._renderItem = function( ul, item) {
	          var re = new RegExp( this.term) ;
	          var t = ui.item.value.replace(re,"<span style='font-weight:bold;color:Blue;'>" + 
	                  this.term + 
	                  "</span>");
	          return $( "<li></li>" )
	              .data( "item.autocomplete", item )
	              .append( "<a>" + t + "</a>" )
	              .appendTo( ul );
	      };
	  }