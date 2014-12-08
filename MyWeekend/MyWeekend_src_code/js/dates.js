function getWeekEnd() {
	var date = new Date();
		date.setUTCHours(23);
		date.setUTCMinutes(0);
		date.setUTCSeconds(0);
		date.setUTCMilliseconds(0);

		var num = (7 - date.getUTCDay());
		if(date.getUTCDay() == 0) {
			num = 0;
		}
		var d = date.getUTCDate()+num;
		date.setUTCDate(d);
	
	
		date.setUTCHours(23);
		return date;
}