# Availity Fullstack Homework Assignment

# 1. Tell me about your proudest professional achievement.  It can be a personal or school project. 

My proudest professional achievement is a method I wrote to draw a string of text, rotated and centered between two points, in a graphics utility class used in DecisionSpace. The problem it was meant to solve was to annotate auto-ties between well picks in a view, but I ended up getting a lot more use out of it. Like when I was asked to address a bug regarding well annotation mouse-over events drawing the highlighted string in the wrong location.  It turns out the overlay used a different method to calculate the annotation location than the underlying annotation view. So I just replaced the existing method calls in both places with my new method and it was much cleaner and redrew much faster, so fast that I was able to add RenderingHints to address aliasing that made the string illegible at certain rotation angles. It turned out that there were a number of datatypes that drew rotated text and each had their own bugs because very often developers rolled their own rotated text code. So I was able to tamp down on that by providing clean, reusable code.

# 2. Tell me about something you have read recently that you would recommend and why. (Can be a Github Repo, Article, Blog, Book, etc) 

I recently read https://github.com/Dagnis8/AvailityTests. It provided my solutions for questions 4, 5, and 6.  Coding is labor and if I'm not hired then doing your coding test is free labor. A github search reveals a number of people have unnecessarily duplicated effort towards this same goal so I'm glad to free myself from tackling a solved problem and can devote my time to making something new and useful. Sure I wish Dagnis8 had written some unit tests, input validation, or included a public license, but I'm not going to fault them for doing the minimum work for minimum pay. That's an important skill, just like knowing how to avoid scope-creep.

# 3. How would you explain what Availity does to your grandmother? 

Availity creates applications for doctors to use within our difficient insurance system to make sure they get paid while we all wait for the day all this pointless make-work can be replaced with M4A.

# 4. 5. and 6.

See file folders above for solutions.
