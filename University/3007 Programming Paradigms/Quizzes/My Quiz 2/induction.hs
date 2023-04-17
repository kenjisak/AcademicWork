data Gzk = Mos | Egg Gzk Char deriving (Show)

xyz ::Gzk -> [Char] --foo
xyz Mos = []    --bar
xyz (Egg x y) = (y: (xyz x)) --qux 

ham ::Gzk -> Int
ham Mos = 0 --ukr
ham (Egg x y) = (ham x) + 1 --shm

length' :: [Char] -> Int --lg0
length' [] = 0 --lg1
length' (h:t) = 1 + length' t --lg2

-- Prove ham A == length (xyz A)

-- Base case: ham Mos == length (xyz Mos)

-- RHS length (xyz Mos)
-- length [] --bar
-- 0 --lg1

-- LHS ham Mos
-- 0 --ukr
-- QED

-- Inductive Assumption: ham (Egg Mos t) == length (xyz (Egg t Mos))

-- Inductive Case: ham (Egg h t) == length (xyz (Egg h t))
-- RHS length (xyz (Egg h t))
-- length (y: (xyz t)) --qux
-- length (y: (xyz (Egg t Mos))) --qux
-- length (y: (xyz Mos)) --qux
-- length (y: []) --bar
-- 1 + length [] --lg2
-- 1 + 0 --lg1
-- 1 --Math

-- LHS ham (Egg h t)
-- (ham (Egg t Mos)) + 1 --shm
-- (ham Mos) + 1 --shm
-- 0 + 1 --ukr
-- 1 --Math
-- QED




-- Inductive Case: ham (Egg Mos y) == length (xyz (Egg Mos y))

--RHS length (xyz Egg Mos y)
--length (y: (xyz Mos)) --qux
--length (y: []) --bar
--1 + length [] --lg2
--1 + 0 --lg1
--1 --Math

--LHS ham Egg Mos y
--(ham Mos) + 1 --shm
--0 + 1 --ukr
--1 --Math
--QED
