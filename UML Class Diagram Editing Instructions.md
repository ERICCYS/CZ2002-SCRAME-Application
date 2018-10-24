# UML Diagram Editing Instructions

#### 24/10/2018

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

  - totalMark (Doesn't need to be changed)

- Mgrs
  Combine the Mgrs to the classes, using dependency relationship. (Can refer to the lecture notes)


###### `Note`: Since the conflict of UML Diagram file (.vpp) cannot be resolve, I recommend that we don't do the changes together at the same time, this will be messy. Thus, we should do it separately at separate time. After the previous person pushed, then the next person pull and continue working

| Changes                | Allocation  | Date     |
| :--------------------: | :---------: | :------: |
| CourseComponent        | Eric        | Thursday |
| Course                 |             | Friday   |
| Marks                  |             | Saturday |
| Mgrs and Other changes |             | Sunday   |
