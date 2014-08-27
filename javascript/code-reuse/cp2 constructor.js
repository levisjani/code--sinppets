<script>
			/* Title: Classical Pattern #2 - Rent a Constructor (a pattern that should be generally avoided)
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

			var kid = new Child("Patrick");
			console.log(kid.name); // "Patrick"

			// Drawback 1: nothing from the prototype gets inherited
			console.log(typeof kid.say); // "undefined"

			// Multiple Inheritance by Borrowing Constructors
			function Cat() {
				this.legs = 4;
				this.say = function () {
					return "meaowww";
				}
			}

			function Bird() {
				this.wings = 2;
				this.fly = true;
			}

			function CatWings() {
				Cat.apply(this);
				Bird.apply(this);
			}

			var jane = new CatWings();
			console.dir(jane);

		</script>
