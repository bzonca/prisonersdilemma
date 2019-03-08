# Iterated Prisoner's Dilemma

Final project for CS 225

## Prisoner's Dilemma

Prisoner's Dilemma is a scenario in which two players agree to cooperate, but individually can screw the other over to achieve a higher reward. This program simulates an iterated version of this game, and will pair a neural network with different strategies to see how it behaves.

### Background

Prisoner’s Dilemma is a classic game theory scenario that was developed in 1950 by Merrill Flood and Melvin Dresher. The scenario can be observed in evolution, economics, politics, and sociology since it deals with cooperation, defection, and trust.

The dilemma occurs when two players face each other and choose to cooperate or defect without knowing the other player’s choice. They can both cooperate for a small reward, or one can defect at the chance to earn a large reward while the other player suffers a large fine (if the other player chose to cooperate). If both players defect, a small fine is issued to both players. A single instance of this game favors both players defecting (the Nash Equilibrium of the situation), however many unique outcomes arise when this game is repeated over time.

It is possible that players can build trust and cooperate, which is why it is an interesting situation to apply a simple neural network to play the game. Decisions in this iterated version differ from a single scenario because the player can take in previous outcomes and use them to determine their next decision. There are certain strategies developed that are responsive in that their decisions always take in account the other player’s previous move. Because of the success of predefined strategies that take in previous game data, it appears to be a prime environment to let a neural network learn the game, observe the results, and make decisions. In addition to building trust and having the capacity for forgiveness and avenging, Iterated Prisoner’s Dilemma is not a zero-sum game. Both players can “win” and cooperate by always choosing to cooperate (small reward), or by alternating who cooperates (large reward for defector).

This project will primarily answer the question of the feasibility of neural networks playing, and what strategy it adapts. The network will play against various strategies, player input, and even itself. The data gathered from these simulations will help form an answer to the question of strategy.

Many scenarios will be simulated with a neural network given previous game results as input and an output to “Defect” or “Cooperate”.
