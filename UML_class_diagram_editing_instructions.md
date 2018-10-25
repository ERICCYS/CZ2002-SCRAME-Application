# UML Diagram Editing Instructions

### TO DO
Regarding today's meeting, the following things needs to be changed

- Student (Entity) (Fine for now)
- Professor (Entity) (Fine for now, can add some more info if needed)
- Course (Entity)
  - Changes
    - profInCharge: String --> profInCharge: Professor
  - Removal
    - examWeightage
    - courseWorkWeightage
    - courseWorks <String, int>[] (We don't need these since we should use other Classes to represent the courseWorks)

  - Addition
    - totalVacancies: int (Or totalSeats: int)
  - The rest doesn't need to be changed
- `CourseComponent` (Interface) (This is a new stuff need to be added)
  - (This is an interface for the purpose of conveniently store the marks for each course component)
  - (Two Classes will implement this Interface)


- СourseRegistration (Entity)
  - Changes
    - studentID: String --> student: Student
    - courseID: String --> course: Course (We need to pass in the Student and Course reference into the CourseRegistration class)

- Marks (Entity)
  - Changes
    - studentID: String --> student: Student
    - courseID: String --> course: Course

  - Removal
    - examMark: int (Since we will put it inside a new HashMap<Component,double> which will also keep track of the examMark)

  - Addition
    - courseWorkMarks: <Component, double>
    - (We need to identify which main-component should be calculated into the final marks, by looking at how may sub-components it has)

  - totalMark (Doesn't need to be changed)

- Mgrs
  Combine the Mgrs to the classes, using dependency relationship. (Can refer to the lecture notes)


##### `Note`: Since the conflict of UML Diagram file (.vpp) cannot be resolve, I recommend that we don't do the changes together at the same time, this will be messy. Thus, we should do it separately at separate time. After the previous person pushed, then the next person pull and continue working


| Changes                | Allocation  | Date     | Status   |
| :--------------------: | :---------: | :------: | :------: |
| CourseComponent        | Eric        | Thursday | Done     |
| Course                 |             | Friday   |      |
| Marks                  | Ian         | Saturday |      |
| Mgrs and Other changes | Kenneth     | Sunday   |      |

### How To?

#### Step 0: Find your work:

Inside the table in this .md file (above...) put you name under the Allocation column.

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/add_your_allocation.png )

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/allocate_your_work.png)

#### Step 1: Pull the repo first

Before you change everything, make sure the code/file on your local side is the latest. Thus, you need to pull the changes.

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/before_changing_everything.png)

#### Step 2: Find the UML Diagram file and Make your changes

Follow the instruction to find the project and make your changes

- Find the project

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/find_UML_diagrams.png)

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/open_UML_diagrams.png)

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/note_on_UML_diagrams.png)

- Change of UML Diagrams (Your turn!)

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/change_UML_diagrams.png)

- After doing some changes you will find some new file in the project folder

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/after_change_UML_diagrams.png)

- Make sure everything is fine, then you can push, cool!

#### Step 3: Commit and Push your changes

- Go to GitKraken, (I really recommend you have this tool), stage changes first

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/stage_files.png)

- Commit them, with appropriate commit message
- Good commit message would be "Add XXX(feature)", "Update XXX", "Edit XXX" ect.

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/commit_changes.png)

- `DON'T FORGET TO PUSH`

![alt text](https://github.com/MAXI0008/CZ2002-SCRAME-Application/raw/master/images/push_changes.png)

#### Nice Work dude! You have made a great contribution to our SCRAME!
