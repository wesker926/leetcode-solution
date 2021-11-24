// Package s1
// @author: wesker.gh
// @date: 2021/11/24
// @description: 按顺序枚举
package s1

func originalDigits(s string) string {
	origin, num := make([]int, 26), make([]int, 10)
	for _, c := range s {
		origin[c-'a']++
	}

	num[0] = sub(origin, []int{25, 4, 17, 14}, origin[25])
	num[2] = sub(origin, []int{19, 22, 14}, origin[22])
	num[4] = sub(origin, []int{5, 14, 20, 17}, origin[20])
	num[6] = sub(origin, []int{18, 8, 23}, origin[23])
	num[8] = sub(origin, []int{13, 8, 6, 7, 19}, origin[6])

	num[1] = sub(origin, []int{14, 13, 4}, origin[14])
	num[3] = sub(origin, []int{19, 7, 17, 4}, origin[19])
	num[5] = sub(origin, []int{5, 8, 21, 4}, origin[5])
	num[7] = sub(origin, []int{18, 4, 21, 13}, origin[18])

	num[9] = sub(origin, []int{13, 8, 4}, origin[8])

	str := make([]byte, 0)
	for i := 0; i < len(num); i++ {
		for j := 0; j < num[i]; j++ {
			str = append(str, byte(i+'0'))
		}
	}
	return string(str)
}

func sub(origin, reduce []int, x int) int {
	for _, i := range reduce {
		origin[i] -= x
	}
	return x
}

//zero    z
//one        o
//two     w
//three      t
//four    u
//five       f
//six     x
//seven      s
//night   g
//nine         i
//
//a b c d e f g h i j k l m n o p q r s t u v w x y z
//0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5
