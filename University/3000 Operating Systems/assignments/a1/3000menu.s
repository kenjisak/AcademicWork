	.file	"3000menu.c"
	.text
	.section	.rodata.str1.1,"aMS",@progbits,1
.LC0:
	.string	"Running %s\n"
	.text
	.globl	run_program
	.type	run_program, @function
run_program:
.LFB51:
	.cfi_startproc
	endbr64
	pushq	%rbx
	.cfi_def_cfa_offset 16
	.cfi_offset 3, -16
	subq	$16, %rsp
	.cfi_def_cfa_offset 32
	movl	%edi, %ebx
	movq	%fs:40, %rax
	movq	%rax, 8(%rsp)
	xorl	%eax, %eax
	movslq	%edi, %rdx
	leaq	menu(%rip), %rax
	movq	(%rax,%rdx,8), %rdx
	leaq	.LC0(%rip), %rsi
	movl	$1, %edi
	movl	$0, %eax
	call	__printf_chk@PLT
	call 	fork@PLT
	testl	%eax, %eax
	je	.L5
	leaq	4(%rsp), %rdi
	call	wait@PLT
	movq	8(%rsp), %rax
	subq	%fs:40, %rax
	jne	.L6
	addq	$16, %rsp
	.cfi_remember_state
	.cfi_def_cfa_offset 16
	popq	%rbx
	.cfi_def_cfa_offset 8
	ret
.L5:
	.cfi_restore_state
	leaq	menu(%rip), %rax
	leal	1(%rbx), %edx
	movslq	%edx, %rdx
	movq	$0, (%rax,%rdx,8)
	movslq	%ebx, %rbx
	leaq	(%rax,%rbx,8), %rsi
	movq	(%rax,%rbx,8), %rdi
	movq	environ(%rip), %rdx
	call	execve@PLT
	movl	$-1, %edi
	call	exit@PLT
.L6:
	call	__stack_chk_fail@PLT
	.cfi_endproc
.LFE51:
	.size	run_program, .-run_program
	.section	.rodata.str1.1
.LC1:
	.string	"\nChoose a program to run:\n"
.LC2:
	.string	"%d. %s\n"
.LC3:
	.string	"\nYour choice? "
	.text
	.globl	choose_program
	.type	choose_program, @function
choose_program:
.LFB52:
	.cfi_startproc
	endbr64
	pushq	%r13
	.cfi_def_cfa_offset 16
	.cfi_offset 13, -16
	pushq	%r12
	.cfi_def_cfa_offset 24
	.cfi_offset 12, -24
	pushq	%rbp
	.cfi_def_cfa_offset 32
	.cfi_offset 6, -32
	pushq	%rbx
	.cfi_def_cfa_offset 40
	.cfi_offset 3, -40
	subq	$40, %rsp
	.cfi_def_cfa_offset 80
	movq	%fs:40, %rax
	movq	%rax, 24(%rsp)
	xorl	%eax, %eax
	movq	$0, 8(%rsp)
	movq	$0, 16(%rsp)
	leaq	.LC1(%rip), %rdi
	call	puts@PLT
	movq	menu(%rip), %rcx
	testq	%rcx, %rcx
	je	.L12
	movl	$1, %ebx
	leaq	.LC2(%rip), %r13
	leaq	-8+menu(%rip), %r12
.L9:
	movl	%ebx, %ebp
	movl	%ebx, %edx
	movq	%r13, %rsi
	movl	$1, %edi
	movl	$0, %eax
	call	__printf_chk@PLT
	addq	$1, %rbx
	movq	(%r12,%rbx,8), %rcx
	testq	%rcx, %rcx
	jne	.L9
.L8:
	leaq	.LC3(%rip), %rsi
	movl	$1, %edi
	movl	$0, %eax
	call	__printf_chk@PLT
	leaq	16(%rsp), %rsi
	leaq	8(%rsp), %rdi
	movq	stdin(%rip), %rdx
	call	getline@PLT
	movl	$10, %edx
	movl	$0, %esi
	movq	8(%rsp), %rdi
	call	strtol@PLT
	movq	%rax, %rbx
	movq	8(%rsp), %rdi
	call	free@PLT
	testl	%ebx, %ebx
	jle	.L13
	cmpl	%ebx, %ebp
	jl	.L13
	leal	-1(%rbx), %eax
.L7:
	movq	24(%rsp), %rdx
	subq	%fs:40, %rdx
	jne	.L16
	addq	$40, %rsp
	.cfi_remember_state
	.cfi_def_cfa_offset 40
	popq	%rbx
	.cfi_def_cfa_offset 32
	popq	%rbp
	.cfi_def_cfa_offset 24
	popq	%r12
	.cfi_def_cfa_offset 16
	popq	%r13
	.cfi_def_cfa_offset 8
	ret
.L12:
	.cfi_restore_state
	movl	$0, %ebp
	jmp	.L8
.L13:
	movl	$-1, %eax
	jmp	.L7
.L16:
	call	__stack_chk_fail@PLT
	.cfi_endproc
.LFE52:
	.size	choose_program, .-choose_program
	.globl	main
	.type	main, @function
main:
.LFB53:
	.cfi_startproc
	endbr64
	subq	$8, %rsp
	.cfi_def_cfa_offset 16
.L19:
	call	choose_program
	cmpl	%eax, QUIT(%rip)
	je	.L22
	cmpl	$-1, %eax
	je	.L19
	movl	%eax, %edi
	call	run_program
	jmp	.L19
.L22:
	movl	$0, %eax
	addq	$8, %rsp
	.cfi_def_cfa_offset 8
	ret
	.cfi_endproc
.LFE53:
	.size	main, .-main
	.globl	QUIT
	.data
	.align 4
	.type	QUIT, @object
	.size	QUIT, 4
QUIT:
	.long	3
	.globl	menu
	.section	.rodata.str1.1
.LC4:
	.string	"/usr/bin/ls"
.LC5:
	.string	"/usr/bin/whoami"
.LC6:
	.string	"/usr/bin/top"
.LC7:
	.string	"QUIT"
	.section	.data.rel.local,"aw"
	.align 32
	.type	menu, @object
	.size	menu, 40
menu:
	.quad	.LC4
	.quad	.LC5
	.quad	.LC6
	.quad	.LC7
	.quad	0
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
