Markov text generation is a well known computer science algorithm to analyze data. When run in reverse, Markov text generation can help 
predict the source of an unknown text. This process can be used to identify SPAM or to ascertain if Bacon wrote Romeo and Juliet.

In this project I created a faster implementation than the brute-force Markov method given and made a class named EfficientMarkov 
based on using maps rather than rescanning the training text. I tested this class with JUnit tests in MarkovTest by modifying 
a method in that class. 

Then, I created a class WordGram that used a word-markov model rather than the character-markov model I started with. 
After, I created a class EfficientWordMarkov, modeled on EfficientMarkov and with the same structure in terms of methods --- 
but using WordGram objects rather than Strings. Finally, I wrote some of my own JUnit tests to verify that the class Wordgram was correct.

I also made an empirical analysis of runtimes comparing the four different classes I modified and/or created to understand how different
programming algorithms behaved in terms of runtime efficiencies.
