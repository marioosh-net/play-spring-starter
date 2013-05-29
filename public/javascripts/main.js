$(document).ready(function(){
	$('#da').prop('disabled', true);
	$('.d').change(function(){
		$('#da').prop('disabled', true);
		$('.d').each(function(){
			if($(this).attr('checked')) {
				$('#da').prop('disabled', false);
			}
		});
	});
});