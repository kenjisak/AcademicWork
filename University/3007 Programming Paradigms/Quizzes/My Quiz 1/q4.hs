q4 :: [(Int,Int,Int,Int)] -> [Int]
q4 list = [ 2*w^3 + 2*x^2 + 3*y + z | (w,x,y,z) <- list, y > 3 && x < w]