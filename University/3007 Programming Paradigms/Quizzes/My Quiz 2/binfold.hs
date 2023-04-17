-- fold question
-- switches the place of the first two elements in a list

-- import Data.Char

-- oper' :: Char -> [Char] -> [Char]
-- oper' letter [] = [letter] -- if y is empty, then x is added to the front of y
-- oper' letter (h:t)
-- -- if x char is within the string "INSPIRING" or x is greater than the head of y, then x is added to the front of y
--   | elem letter "CELEBRATED" || ord(letter) > ord(h) = (h:t) ++ [letter] 
--   | otherwise = letter:(h:t) -- otherwise letter is added to the end of string

-- foldthis :: [Char] -> [Char]
-- foldthis letters = foldr oper' [] letters

-- --foldthis "AOKBST"

-- -- fold' :: [Char] -> [Char]
-- -- fold' [] = []
-- -- fold' (h:t) = oper' h (fold' t)

import Data.Char

oper' :: Char -> [Char] -> [Char]
oper' letter [] = [letter]
oper' letter (h:t)
  | elem letter "CELEBRATED" || ord(letter) > ord(h) = (h:t) ++ [letter] 
  | otherwise = letter:(h:t)

foldthis :: [Char] -> [Char]
foldthis letters = foldr oper' [] letters

--foldthis "AOKBST"
