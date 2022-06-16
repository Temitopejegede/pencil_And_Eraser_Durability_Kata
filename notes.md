# Feedback

Thanks for doing this Temi! It's clear you put time, focus and effort into this, which I appreciate and will serve you well as you grow in your career and craftsmanship!

I try to be as thorough as possible with this sort of review in order to give you hopefully good practice information as well as new ways to think about the craft. I'll list some general thoughts and comments on commits here in this file, and then 'suggest changes' against the source files with comments there as well when it pertains to specific pieces of code.

The hope is that this encourages you and gives you insight you generally don't get from a presentation etc. 

## Project Setup

You generally will want to use a build system like gradle or maven. This lets your project be more easily built across different developer setups and allow them to retain their own preferences in things like the iml file (intellij file.) 

Take a look at using `.gitignore` to exclude files and folders. Generally you'll want to exclude the following:
```
.idea/
lib/
out/
*.iml
```
This allows git to ignore all built artifacts and preference files etc, while still allowing every dev to easily start the project and build their artifacts from source.

## Code Comments

I appreciate the time and effort that you put into the code comments. It shows you care and have an eye for detail. That said, I'm going to say something that probably contradicts what academia says: The less comments the better! I don't mean to make the code less clear, but that is a generally better approach.

Code should be 'self documenting' in that it should be clear what it's doing, without needing comments. This is done through several things
- Variable names: I think you already do this really well. Having full names that are specific does a great job at making your code clear
- Explanatory variables: Did you just do something complicated? Name the result something that makes what you just did more clear, even if it means breaking something up into more local variables
- Function Names: naming functions specifically and clearly is really helpful, as well as making them the same 'level of abstraction'. This follows the same pattern as explanatory variables.
- Tests: Your tests, if done really well, act as a form of documentation with examples that should explain behaviors the same way your comments currently do. As a reader I should be able to hop in and skim / read the tests to know how everything works.

Code comments should be left for three cases
1) You can't further make the code clear, but it's still not obvious. This is kind of an admi defeat situation
2) You need to explain the _why_. Because the code should be clear as to the what, that part should be covered. But just knowing _what_ something does doesn't give us the full picture. Having a _why_ can be really helpful.
3) Context is necessary to help understand the next piece of code.

## Tests

You had your tests nicely organized. You can take this one step further by breaking them out into files based on what they're testing. Just because they're all testing the same class doesn't mean they need to be in the same file! This makes it even easier to navigate them and helps you have less to look at all at once when focused on a specific 'feature'.


## Commit History

Often, especially as we're doing a hobby project or trying to meet a deadline our commits are very brief and vague. Katas like this are a great time to practice good commit messages so that they're more natural to do under pressure / in a rush.

A good commit message follows a couple standards that most devs ignore. Here's two tips:
- A good commit message is in the present imperative. It tells what the patch does to the code base 
  - Instead of “I walked the dog”, write “Walk the dog”
- A good commit message is not what you did, but why you did it
  - Instead of “Add five to tax calculation”, write “Account for base tax amount”
  - This is harder to do and even less common to see

### Commit specific comments

a99a978c37d2a1e9a57464403c55fae32cc1f0f7
- Looks like there are a couple test signatures written
  - I'm betting you were plotting out in your head where you were going to go. To be really anal it's good to use `git add -p` to only add what's relevant to the commit, or copy paste those headers out of the file when you commit, so your commit only contains that one complete, passing test
- Looks like there is some implementation that aren't tied to tests
  - In your next kata, try to not write _any_ code that wasn't driven by a test. Write your first test out and then write _just enough_ code to pass that guy
  - Try not to write code for the 'next test'

3a92c92
- Looks like here we got tests for the current implementation. Next time try writing each one of these guys one at a time, and use that to drive the implementation file, and do a commit for each passing test

51719d6
- Looks like this guy was a satisfying refactor! Technically in TDD you should do Red Green Refactor all in one commit. Write a failing test (red), make the t est pass (green), and then refactor.
- That said, a refactor generally shouldn't change any tests. If it does, that indicates that we were testing at a too low level. This is really challenging to do well!
- Finally, if you need to refactor tests, you want to try to add no new functionality. I think you did that successfully here, from going over the code

bcd01b2
- Good job! This looks like a single test driving functionality. Looks like you're getting the hang of it. :D
