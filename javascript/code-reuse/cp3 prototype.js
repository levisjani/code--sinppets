<script>
			/* Title: Classical Pattern #3 - Rent and Set Prototype (a pattern that should be generally avoided)
			 */

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
				Parent.apply(this, arguments);
			}

			Child.prototype = new Parent();

			var kid = new Child("Patrick");
			console.log(kid.name); // "Patrick"
			console.log(typeof kid.say); // function
			console.log(kid.say()); // Patrick
			console.dir(kid);
			delete kid.name;
			console.log(kid.say()); // "Adam"

		</script>
