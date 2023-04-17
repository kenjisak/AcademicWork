-- Kenji Isak Laguan 101160737

-- test cases for negative discriminant and 0 real roots: input: fullquadratic 1 1 1 output: [] and input: fullquadratic 2 (-3) 4 = []
-- test cases for discriminant equal to 0 and 1 real root:  input: fullquadratic 1 6 9 output: [-3.0] and input: fullquadratic (-4) 12 (-9) output: [1.5]
-- test cases for positive discriminant and 2 real roots:  input: fullquadratic (-1) 2 3 output: [-1.0,3.0] and input: fullquadratic (-1) 4 5 output: [-1.0,5.0]

import Debug.Trace
discriminant :: Double -> Double -> Double -> Double
discriminant a b c = b ^ 2 - 4 * a * c -- calculates the discriminant

posquadratic :: Double -> Double -> Double -> Double
posquadratic a b c = (-b + sqrt (discriminant a b c)) / (2 * a) -- calculates positive side of quadratic equation

negquadratic :: Double -> Double -> Double -> Double
negquadratic a b c = (-b - sqrt (discriminant a b c)) / (2 * a) -- calculates negative side of quadratic equation

onerealroot :: Double -> Double -> Double -> Double
onerealroot a b c -- calculates the 1 real root for the quadratic equation
    | posquadratic a b c == 0 = posquadratic a b c -- if the positive side of quadratic equation is equal to 0 then return that value
    | otherwise = negquadratic a b c -- else its the negative side of quadratic equation

fullquadratic :: Double -> Double -> Double -> [Double]
fullquadratic a b c 
    | discriminant a b c < 0 = trace ("The discriminant is " ++ show (discriminant a b c) ++ " which is negative, therefore has no real roots.") [] -- if discriminant is negative then no real solutions, returns empty list since no real roots.
    | discriminant a b c == 0 = trace ("The discriminant is " ++ show (discriminant a b c) ++ " therefore there is 1 real root.") [onerealroot a b c] -- if discriminant is 0 then 1 real solution, use helper function to find the 1 real root.
    | otherwise = trace ("The discriminant is " ++ show (discriminant a b c) ++ " which is positive, therefore there are 2 real roots.") [posquadratic a b c, negquadratic a b c] -- discriminant is positive then 2 real solutions, and calculate full quadratic equation and return both roots using the helper functions.

