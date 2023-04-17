import Debug.Trace

convert :: Char -> Int
convert char 
    | char == 'a' = 1 
    | char == 'b' = 2 
    | char == 'c' = 3 
    | otherwise = trace ("elegant") 4

q2 :: [Char] -> Int
q2 [] = 0
q2 (h:t)
    | convert h < 3 = convert h + q2 (t)
    | otherwise = q2 (t)