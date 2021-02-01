<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="//unpkg.com/vue/dist/vue.js"></script>
<script src="//unpkg.com/element-ui@2.1.0/lib/index.js"></script>
</head>

<body>
	<script type="text/x-template" id="modal-template">
  <transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">

          <div class="modal-header">
            <slot name="header">
              default header
            </slot>
          </div>

          <div class="modal-body">
            <slot name="body">
              default body
            </slot>
          </div>

          <div class="modal-footer">
            <slot name="footer">
              default footer
              <button class="modal-default-button" @click="$emit('close')">
                OK
              </button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>
</script>

	<!-- app -->
	<div id="app">
		<button id="show-modal" @click="showModal = true">Show Modal</button>
		<!-- use the modal component, pass in the prop -->
		<modal v-if="showModal" @close="showModal = false"> <!--
      you can use custom content here to overwrite
      default content
    -->
		<h3 slot="header">custom header</h3>
		</modal>
	</div>
	
	<script>
	// register modal component
	Vue.component('modal', {
	  template: '#modal-template'
	})

	// start app
	new Vue({
	  el: '#app',
	  data: {
	    showModal: false
	  }
	})
	</script>
</body>
</html>