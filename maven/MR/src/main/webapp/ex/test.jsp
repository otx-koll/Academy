<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/vue/2.2.4/vue.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>
<div id="app">
    <datepicker @update-date="updateDate"></datepicker>
    <p>{{ date }}</p>
</div>

<script>
Vue.component('datepicker', {
	  template: '<input/>',
	  mounted: function() {
	    var self = this;
	    $(this.$el).datepicker({
	      dateFormat: "yy-mm-dd"
	      ,monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
	      ,monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
	      ,dayNames: ['일', '월', '화', '수', '목', '금', '토']
	      ,dayNamesShort: ['일', '월', '화', '수', '목', '금', '토']
	      ,dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
	      ,changeMonth: true // 월선택 select box 표시 (기본은 false)
	      ,changeYear: true  // 년선택 selectbox 표시 (기본은 false)
	      ,showMonthAfterYear: true // 다음년도 월 보이기
	      ,showOtherMonths: true // 다른 월 달력에 보이기
	      ,selectOtherMonths: true // 다른 월 달력에 보이는거 클릭 가능하게 하기
	      ,onSelect: function(d){self.$emit('update-date',d)}
	    });
	  },
	  beforeDestroy: function(){$(this.$el).datepicker('hide').datepicker('destroy')}
	});

	new Vue({
	  el: '#app',
	  data: {
	    date: null
	  },
	  methods: {
	    updateDate: function(d) {
	      this.date = d;
	    }
	  }
	});
</script>

<script>
// Vue.component('datepicker', {
//   template: '<input/>',
//   mounted: function() {
//     var self = this;
//     $(this.$el).datepicker({
//       dateFormat: "yy-mm-dd",
//       onSelect: function(d){self.$emit('update-date',d)}
//     });
//   },
//   beforeDestroy: function(){$(this.$el).datepicker('hide').datepicker('destroy')}
// });

// new Vue({
//   el: '#app',
//   data: {
//     date: null
//   },
//   methods: {
//     updateDate: function(d) {
//       this.date = d;
//     }
//   }
// });
</script>
</body>
</html>