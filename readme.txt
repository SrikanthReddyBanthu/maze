1) All lines have equal number of characters
2) * symbol is used to show maze current position
3) Below is x and y axis assumption made (x and y index start from 0)

    Lets consider below example (Ex1:)
    1 2 3
    4 5 6
    7 8 9

    For coordinates x = 0, y = 0 value is 1
    For coordinates x = 1, y = 1 value is 5
    For coordinates x = 0, y = 2 value is 7
    For coordinates x = 1, y = 2 value is 8
    For coordinates x = 2, y = 2 value is 9

    As per above example (Ex1:)
    lets say current position (x: 1, y:1) with value 5, when making a LEFT move then x = 1, y = 0 and value is 4
    lets say current position (x: 1, y:1) with value 5, when making a RIGHT move then x = 1, y = 2 and value is 6
    lets say current position (x: 1, y:1) with value 5, when making a TOP move then x = 0, y = 1 and value is 2
    lets say current position (x: 1, y:1) with value 5, when making a BOTTOM move then x = 2, y = 1 and value is 8

4) Lets say if there is only one possible way to move, I am moving maze without prompting user to continue.
5) When there are two possible ways, one is maze facing direction and other is opposite direction then we will continue with maze facing direction
6) When there are multiple possible ways, then we will display list of options to user to choose which direction they want to go.
7) Assuming maze can only move one step at a time and no diagonal movements
