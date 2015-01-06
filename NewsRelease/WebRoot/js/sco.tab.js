/* ==========================================================
 * sco.tab.js
 * http://github.com/terebentina/sco.js
 * ==========================================================
 * Copyright 2013 Dan Caragea.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */

/*jshint laxcomma:true, sub:true, browser:true, jquery:true, devel:true */

;(function($, undefined) {
	"use strict";

	var pluginName = 'scojs_panes';

	function Panes($wrapper, options) {
		var self = this;

		this.options = $.extend({}, $[pluginName].defaults, options);
		var transitionEnd = ($.support.transition && this.options.easing) ? $.support.transition.end : null;
		this.$pane_wrapper = $wrapper;
		if (this.options.easing) {
			this.$pane_wrapper.addClass(this.options.easing);
		}

		this.$pane_wrapper.on('select.' + pluginName, function(e, options, index) {
			if (!e.namespace || e.namespace != pluginName) {
				return;
			}
			var  direction = 'left'
				,type = 'next'
				;
			if (options.active > index) {
				direction = 'right';
				type = 'prev';
			}

			function onEnd() {
				self.$panes.eq(options.active).removeClass('active ' + direction);
				self.options.active = index;
				self.$panes.eq(index).removeClass([type, direction].join(' ')).addClass('active');
			}

			if (transitionEnd) {
				self.$pane_wrapper.one(transitionEnd, onEnd);
			}
			self.$panes.eq(index).addClass(type)[0].offsetWidth; // force reflow
			self.$panes.eq(options.active).addClass(direction);
			self.$panes.eq(index).addClass(direction);
			if (!transitionEnd) {
				onEnd();
			}
		});

		this.$panes = this.$pane_wrapper.children();

		this.$panes.eq(this.options.active).addClass('active');
	}

	$.extend(Panes.prototype, {
		select: function(index) {
			if (index !== this.options.active) {
				if (typeof this.options.onBeforeSelect != 'function' || this.options.onBeforeSelect.call(this, index) !== false) {
					this.$pane_wrapper.trigger('select.' + pluginName, [this.options, index]);
					return true;
				}
			}
			return false;
		}

		,next: function() {
			var  tab_count = this.$panes.length
				,next
				;
			if (this.options.active === tab_count - 1) {
				next = 0;
			} else {
				next = this.options.active + 1;
			}
			return this.select(next);
		}

		,prev: function() {
			var prev;
			if (this.options.active === 0) {
				prev = this.$panes.length - 1;
			} else {
				prev = this.options.active - 1;
			}
			return this.select(prev);
		}
	});

	$[pluginName] = function(elem, options) {
		if (typeof elem === 'string') {
			elem = $(elem);
		}
		return new Panes(elem, options);
	};

	$[pluginName].defaults = {
		active: 0
		,easing: ''
	}
})(jQuery);

;(function($, undefined) {
	"use strict";

	var pluginName = 'scojs_tab';

	function Tab($header_wrapper, options) {
		this.options = $.extend({}, $.fn[pluginName].defaults, options);
		this.$header_wrapper = $header_wrapper;

		if (this.options.content === undefined) {
			this.options.content = this.$header_wrapper[this.options.mode]('.pane-wrapper');
		}

		var  self = this
			,auto_click = false
			;
		if (typeof this.options.onBeforeSelect == 'function') {
			this.options.onBeforeSelect = $.proxy(this.options.onBeforeSelect, self);
		}

		this.panes = $.scojs_panes(this.options.content, this.options);
		this.$header_wrapper.find('> li').removeClass('active').eq(this.options.active).addClass('active');

		this.$header_wrapper.on('click.' + pluginName, 'a', function(e) {
			var  $this = $(this)
				,$my_li = $this.closest('li')
				,my_index = $my_li.index()
				;

			if (!$.address || $this.attr('href') == '#') {
				e.preventDefault();
			}

			if (self.panes.select(my_index)) {
				self.$header_wrapper.find('> li.active').removeClass('active');
				$my_li.addClass('active');
			}
		});

		if ($.address) {
			$.address.externalChange(function(e) {
				var hash = '#' + e.value.slice(1);
				self.$header_wrapper.find('> li a').each(function() {
					var $this = $(this);
					if ($this.attr('href') === hash) {
						$this.trigger('click');
						return false;
					}
				});
			}).history(true);
		}
	}

	$.extend(Tab.prototype, {
		select: function(index) {
			this.$header_wrapper.find('> li:eq(' + index + ') a').trigger('click');
			return this;
		}
	});


	$.fn[pluginName] = function(options) {
		return this.each(function() {
			var obj;
			if (!(obj = $.data(this, pluginName))) {
				var $this = $(this)
					,data = $this.data()
					,opts = $.extend({}, $.fn[pluginName].defaults, options, data)
					;
				obj = new Tab($this, opts);
				$.data(this, pluginName, obj);
			}
		});
	};


	$[pluginName] = function(elem, options) {
		if (typeof elem === 'string') {
			elem = $(elem);
		}
		return new Tab(elem, options);
	};


	$.fn[pluginName].defaults = {
		active: 0
		,mode: 'next'                       // "next" means panes are under headers, "prev" means panes are above headers
		,easing: ''
	};

	$(function() {
		$('[data-trigger="tab"]')[pluginName]();
	});
})(jQuery);
