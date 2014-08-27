<script>
			/* Title: Classical Pattern #3 - Share the Prototype (a pattern that should be generally avoided)
			 */

			function inherit(C, P) {
				C.prototype = P.prototype;
			}

			// the parent constructor
			function Parent(name) {
				this.name = name || 'Adam';
			}

			// adding functionality to the prototype
			Parent.prototype.say = function () {
				return this.name;
			};

			// child constructor
			function Child(name) {
			}

			inherit(Child, Parent);

			var kid = new Child('Patrick');
			console.log(kid.name); // undefined
			console.log(typeof kid.say); // function
			kid.name = 'Patrick';
			console.log(kid.say()); // Patrick
			console.dir(kid);

		</script>
