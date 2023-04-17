	.file	"test.c"
	.text
	.globl	main
	.type	main, @function
main:
.LFB23:
	.cfi_startproc
	endbr64
	movl	$0, %eax
	ret
	.cfi_endproc
.LFE23:
	.size	main, .-main
	.globl	QUIT
	.data
	.align 4
	.type	QUIT, @object
	.size	QUIT, 4
QUIT:
	.long	3
	.globl	menu
	.section	.rodata.str1.1,"aMS",@progbits,1
.LC0:
	.string	"/usr/bin/ls"
.LC1:
	.string	"/usr/bin/whoami"
.LC2:
	.string	"/usr/bin/top"
.LC3:
	.string	"QUIT"
	.section	.data.rel.local,"aw"
	.align 32
	.type	menu, @object
	.size	menu, 32
menu:
	.quad	.LC0
	.quad	.LC1
	.quad	.LC2
	.quad	.LC3
	.ident	"GCC: (Ubuntu 11.2.0-19ubuntu1) 11.2.0"
	.section	.note.GNU-stack,"",@progbits
	.section	.note.gnu.property,"a"
	.align 8
	.long	1f - 0f
	.long	4f - 1f
	.long	5
0:
	.string	"GNU"
1:
	.align 8
	.long	0xc0000002
	.long	3f - 2f
2:
	.long	0x3
3:
	.align 8
4:
