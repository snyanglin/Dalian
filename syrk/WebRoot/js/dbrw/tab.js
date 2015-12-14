// JavaScript Document
function getObject(o) {
	return document.getElementById(o);
}

function HoverLy(d) {
	var y = 2;
	if (d > 2) {
		y = 12;
	}
	for ( var i = y - 1; i <= y; i++) {
		if (i != d) {
			getObject('td_' + i).className = 'normaltab1';
			getObject('tdc_0' + i).className = 'rwdb_undis';
		}
	}
	getObject('tdc_0' + d).className = 'rwdb_dis';
	getObject('td_' + d).className = 'hovertab1';

}
