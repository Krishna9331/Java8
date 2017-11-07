#Transformation
1. Map operation - takes Object of type R and returns U.
2. FlatMap operation - takes object of type R and return more than one types U, T etc.
3. Scanning - carry forward the state from event to event
4. Group By - Categories the output
5. Buffer - In a given timespan list all the input.

#Conditional
1. defaultIfEmpty
2. takeWhile
3. takeWhileIndex
4. skipWhile
5. amb - takes the o/p of Observable which emits the event first
6. skipUntil
7. takeUntil
