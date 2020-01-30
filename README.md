# Neural-Net
Description: This is a Neural Net I wrote. It implements foward and back propogation using linear algebra. 

Note: This code has no main function. Go look at my PongAI or LanguageRecognition projects if you want to see it in action.

I am currently trying to add more hidden layers, but am having a problem with the back propogation. 

What each file/class is: 

NeuralNet: This is the meat and potatoes of the project. It is where the actual implementation of the neural net is. The foward and back propogation equations as well as the arrays for the weights and biases are all stored here. All the other files except MatrixMath are just to make the Neural Net easier to use.

MatrixMath: This file contains all of the Linear Algebra used in the NeuralNet file. This includes regular operations as well as activation functions and randomization.

NeuralNetDriver: This file is solely to make it easier to interact with the neural net. It makes it much easier to format data into the way that the neural net wants to receive it. The contructor for the NeuralNetDriver class requires a Parse object, a FileManager, an IOManager, and some other stuff you can read about in the JavaDoc. It is not neccessary, but is very nice to have.

FileManager: Saves and loads the neural net in its current state. It can save it to whereever you would like.

Parse: The Parse class is an abstract class which is used by a NeuralNetDriver to parse your input into some binary format and vica versa. Follow the JavaDoc to see exactly how data should be parsed.

IOManager: Also an abstract class. NeuralNetDriver uses this class to ask for input and send output info for display. This allows you to display projects using the console or a GUI or anything else you want.

IOConsole: IOConsole is a child of the IOManager class and provides an IOManager for applications that just need the console to get and display info.
