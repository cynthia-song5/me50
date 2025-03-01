# Elderly Patient Exercise Program (2022)

## Description

This program is designed to motivate elderly patients in nursing homes and rehabilitation centers to exercise regularly. My mother, a physical therapist, treats elderly patients with injuries or physical pain and encourages them to exercise to prevent further or worsening conditions. However, she has noticed that very few patients follow through with exercising. While she is not responsible for ensuring they exercise, she wants them to find the incentive to do so, as it would improve their quality of life and reduce the need for frequent treatments.

Creating healthy exercise habits is particularly challenging for elderly patients in a nursing home setting. To address this, I developed a Java-based program that provides customized workout programs tailored to each patient's individual needs. Patients register by entering their preferred workout intensity, which allows the system to recommend appropriate exercises based on their strength and capabilities. 

Each workout includes:

* A detailed explanation of each exercise

* The number of repetitions per exercise

* The name of each exercise

After completing a workout, patients can rate it based on difficulty and enjoyment. These ratings are stored so that patients can reference workouts they enjoyed the most or select workouts based on perceived difficulty. Completing workouts also helps incentivize patients to continue progressing, as intensity levels can increase over time. Additionally, patients have the flexibility to complete multiple workouts in one session if desired.

## Features

For Patients:

* Personalized workout recommendations based on registered intensity level

* Ability to mark workouts as complete

* Option to rate workouts based on difficulty and enjoyment

* Access to previously completed and highly-rated workouts

* Option to complete multiple workouts in a session

For Physical Therapists:

* Ability to create and recommend personalized workout programs

* Selection of exercises from a predefined exercise database

* Customization of workouts, including exercise count and repetitions

* Assigned workouts are stored and accessible only to the specific patient

## Implementation Details

User Data Storage:

* Information for both patients and physical therapists is stored in CSV files for easy access and retrieval across sessions.

Workout Management:

* Workouts are created using object-oriented programming principles, with exercises being components of a larger workout.

* Inheritance is used to generate workouts from individual exercises.

* Linked lists allow for efficient traversal of workouts, improving memory management and ease of access.

Technology Used:

* Java was chosen due to its simplicity, flexibility, and efficiency in handling data storage and user interaction.

## Future Improvements

* Implementing a graphical user interface (GUI) to enhance accessibility

* Displaying images of each exercise within workouts for better understanding

* Adding progress tracking and achievement badges to further incentivize participation

Video Demostration: https://www.youtube.com/watch?v=6Ot58wOm3WI

* Enabling multi-user access with secure authentication for better usability

* This project aims to make exercising more engaging and sustainable for elderly patients, ultimately improving their overall well-being.
