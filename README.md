# Register Machines

## Disclaimer

This project is intended for interest only. It is not a part of any course contents.

## Goal

Implement register machines as described in COMP50003 Models of Computation of the Department of Computing of Imperial
College London

## Milestones

- Parse register machines from a source file
- Execute parsed register machines with given initial configuration
- Output register contents upon halting

## Syntax

$$
\begin{align*}
S&= L;S\;|\;\epsilon\\
L&= L_m:I\\
I&= R_n^+\to L_i\;|\;R_n^-\to L_i,L_j\;|\;\text{HALT}
\end{align*}
$$

### Example Register Machine

$$
\begin{align*}
L_0&:R_1^-\to L_1,L_2\\
L_1&:R_0^+\to L_0\\
L_2&:\text{HALT}
\end{align*}
$$

## Semantics

### Registers

$$
R_n
$$

- Registers store positive integer values only
- No upper limit in the number of registers

### Lines

$$
L_m:I
$$

- Each line is given a label $L_m$ defining the line number
- The instruction $I$ is either one of “Increment”, “Decrement” or “Halt”
- No upper limit in the number of lines

### Instructions

#### Increment

$$
R_n^+\to L_i
$$

- Increases the value stored in $R_n$ by 1, then jumps to $L_i$

#### Decrement

$$
R_n^-\to L_i,L_j
$$

- Decreases the value stored in $R_n$ by 1, then jumps to $L_i$
- If the value in $R_n$ before decrement is 0, $R_n$ will not be changed, then jumps to $L_j$

#### Halt

$$
\text{HALT}
$$

- Terminates the register machine

### Execution

- Given an initial configuration containing the values of all $R_n$
    - Unspecified registers will have the value 0
- Start executing from $L_0$, then jumps to the next line specified by the current instruction
- Terminates when the “Halt” instruction is executed, or jumped to a non-defined $L_m$
