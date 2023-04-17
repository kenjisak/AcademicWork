#include <linux/module.h>
#include <linux/vermagic.h>
#include <linux/compiler.h>

MODULE_INFO(vermagic, VERMAGIC_STRING);

struct module __this_module
__attribute__((section(".gnu.linkonce.this_module"))) = {
 .name = KBUILD_MODNAME,
 .init = init_module,
#ifdef CONFIG_MODULE_UNLOAD
 .exit = cleanup_module,
#endif
 .arch = MODULE_ARCH_INIT,
};

static const struct modversion_info ____versions[]
__used
__attribute__((section("__versions"))) = {
	{ 0x7799aa3d, "module_layout" },
	{ 0xa2c56c31, "param_ops_ulong" },
	{ 0xc3fe87c8, "param_ops_uint" },
	{ 0x72aa82c6, "param_ops_charp" },
	{ 0x86bfe20c, "kmem_cache_alloc_trace" },
	{ 0x972d523a, "kmalloc_caches" },
	{ 0x8b9200fd, "lookup_address" },
	{ 0x800a5533, "commit_creds" },
	{ 0x6dce65ee, "prepare_kernel_cred" },
	{ 0xe2929302, "current_task" },
	{ 0x37a0cba, "kfree" },
	{ 0x4f8b5ddb, "_copy_to_user" },
	{ 0x85abc85f, "strncmp" },
	{ 0x27e1a049, "printk" },
	{ 0x4f6b400b, "_copy_from_user" },
	{ 0xa1c76e0a, "_cond_resched" },
	{ 0x5a34a45c, "__kmalloc" },
	{ 0xb4390f9a, "mcount" },
};

static const char __module_depends[]
__used
__attribute__((section(".modinfo"))) =
"depends=";


MODULE_INFO(srcversion, "A2CE2BC4D8E951D1ADFABC1");
