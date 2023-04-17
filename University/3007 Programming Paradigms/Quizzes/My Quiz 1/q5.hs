q5 :: [Int] -> Int
q5 [] = 0
q5 [one] = 0
q5 (first:second:rest)
    | second > 2 = second + q5 rest
    | otherwise = q5 rest