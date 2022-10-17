# Parking Garage System

This application manages a parking space for a configurable maximum number of vehicles. Each parking space (slot) defined with a
dimension (width and depth). The designed application handle the following functions:

•Each vehicle shall be identified by a model name, unique identification number, Model year and vehicle dimensions (vehicle width and depth).
•Park-in function that marks the arrival time of a vehicle if there is an available slot. The application shall capture such time automatically from the system.
•During the park-in function the application shall pick a free slot based on the active slot
configuration. There are two configurations (i) first come first served slots i.e., the park-in
function will use the first free slot available from the parking garage slots. (ii) best-fit
approach that finds the slot with the minimum dimension to hold the vehicle.
•Park-out function that marks the departure time of a vehicle from the garage. The
application shall capture such time automatically from the system.
•Calculating the parking fees during the park-out based on the time-of-stay with an hourly
rate of 5 EGP.
•Calculating the total income as well as the total number of vehicles that used the parking
garage at any given point in time.
•Displaying the available parking slots.


This application was Applied on it the Object-Oriented concepts(Abstraction, polymorphism,
interfaces, packaging,...), SOLID Principles and Some Design Patterns.

This application developed by:
	•Mohamed Mahmoud Mourad (Me)
	•Eslam Mohamed Ali
