import Data.Char
import Data.Maybe

data Grades = Nonletter Char | A | B deriving (Show) -- 4,3,2, else 1

convertlettergrade:: Grades -> Maybe Int 
convertlettergrade A = Just 4
convertlettergrade B = Just 3
convertlettergrade (Nonletter letter) = Nothing -- in ghci line convertlettergrade (Nonletter 'anychar') will return Nothing as example



-- Question 1: struct induction, with custom algebraic data type. lect 11,12, 15(data type)
data ListInt = Emptylist | Conspair Int ListInt deriving (Show)
--Knowledge Base:

qux::ListInt -> (Int,Int)
qux Emptylist = (0,0)  --Q1    
qux x =(ham x, 1) --Q2

ham::ListInt -> Int
ham (Conspair h _ ) = h --H1

xyz:: (Int,Int) -> Int
xyz(x,1) = x * (x + 1) -- X1
xyz x = 0 -- X2

foo::ListInt -> Int
foo Emptylist = 0 -- F1
foo (Conspair x Emptylist) = 1 -- F2 only 1 
foo (Conspair h t) = 1 + foo t -- F3

bar::ListInt -> ListInt
bar Emptylist = Emptylist -- B1
bar (Conspair h t) = Conspair (foo (Conspair h t)) (bar t) -- B2


-- prove this xyz (qux (bar x)) == (foo x) * (foo x + 1)
-- base case xyz (qux (bar Emptylist)) == (foo Emptylist) * (foo Emptylist + 1)
-- LHS xyz (qux (bar Emptylist))
-- xyz (qux Emptylist) B1
-- xyz (0,0) Q1
-- 0 X2

-- RHS (foo Emptylist) * (foo Emptylist + 1)
-- 0 * (foo Emptylist + 1) F1
-- 0 * (0 + 1) F1
-- 0 * (1) Math
-- 0 Math QED

-- Inductive Assumption: xyz (qux (bar (Conspair t Emptylist))) == (foo (Conspair t Emptylist)) * (foo (Conspair t Emptylist) + 1)

-- Inductive case xyz (qux (bar (Conspair h t))) == (foo (Conspair h t)) * (foo (Conspair h t) + 1)
-- LHS xyz (qux (bar (Conspair h t)))
-- xyz (qux (Conspair (foo (Conspair h t)) (bar t))) B2
-- xyz (ham (Conspair (foo (Conspair h t)) (bar t)), 1) Q2
-- xyz (foo (Conspair h t), 1) H1
-- foo (Conspair h t) * (foo (Conspair h t) + 1) X1

-- RHS foo (Conspair h t) * (foo (Conspair h t) + 1) QED

-----------------------------------------------------------------------------------
--Question 2: convert list comp into fold(accumulate pattern),map(transform pattern),filter(selection pattern) and also using higher order functions(map,fold,filter)....ex. mapDouble and map Double

mydouble:: Int -> Int --func oper
mydouble num = num * 2

mapDouble::[Int] -> [Int] -- without builtin higher
mapDouble [] = [] --basecase given no ints
mapDouble (h:t) = mydouble(h) : mapDouble(t) 
--------------------------------------------------------------
doublemap:: [Int] -> [Int]
doublemap nums = map mydouble nums --built in higher order func
----------------------------------------------------------------------
caesarciph:: Char -> Char
caesarciph letter 
    | (ord letter + 13) > 64 && (ord letter + 13) < 91 = chr(ord letter + 13) -- if uppercase that doesnt exceed when ciphered
    | (ord letter + 13) >= 91 = chr((ord letter + 13) - 26) -- exceeds uppercase cipher ascii, goes past Z
    | otherwise = letter -- non Uppercase char

mapCaesar:: [Char] -> [Char]-- without builtin higher
mapCaesar [] = []
mapCaesar (h:t) = caesarciph(h) : mapCaesar(t)

-- map':: (a -> b) -> [a] -> [b]
-- map' _ [] = []
-- map' oper (h:t) = oper (h) : map' (oper) (t)

caesarmap:: [Char] -> [Char] --built in higher order func
caesarmap word = map (caesarciph) word
-----------------------------------------------------------------------------------
isEven:: Int -> Bool
isEven num
    | mod num 2 == 0 = True
    | otherwise = False

filterEven:: [Int] -> [Int]
filterEven [] = []
filterEven (h:t)
    | isEven(h) == True = h: filterEven(t)
    | otherwise = filterEven(t)

-- filter':: (a -> Bool) -> [a] -> [a]
-- filter' _ [] = []
-- filter' pred (h:t)
--     | pred h == True = h: filter' pred t
--     | otherwise = filter' pred t

evenfilter::[Int] -> [Int]
evenfilter nums = filter isEven nums

--------------------------------------------------------------
-- Question 3:list processing with tail call optimization with Maybe

--------------------------------------------------------------

-- multiply only on the 2nd element

-- list process with tail optimize for add
-- safely getting 2nd element

-- mult:: [Int] -> Maybe Int
-- mult
-- give example code of tail call optimization of sum using Maybe

fact':: Int -> Int -> Maybe Int
fact' 0 acc = Just acc
fact' n acc 
    | n < 0 = Nothing
    | otherwise = fact' (n-1) (n*acc)

-- sum only evens

sum':: [Int] -> Int -> Maybe Int
sum' [] acc = Just acc
sum' (h:t) acc
    | isEven h = sum' (t) (h + acc) -- if even then add to accumulator
    | otherwise = sum' (t) (acc)    -- else not even then just pass current accumulator


--------------------------------------------------------------
-- Question 4:
insertoper:: Int -> [Int] -> [Int]
insertoper num [] = [num]
insertoper num (h:t)
    | num <= h = num : h : t
    | otherwise = h : insertoper num t

insertsort:: [Int] -> [Int]
insertsort [] = []
insertsort (h:t) = insertoper h (insertsort t)

foldinsert:: [Int] -> [Int]
foldinsert nums = foldr insertoper [] nums --[] is accumulator

-- foldr':: (a -> b -> b) -> b -> [a] -> b
-- foldr' _ acc [] = acc -- base case give back accumulator at empty list
-- foldr' oper acc (h:t) = oper h (foldr' oper acc t)





