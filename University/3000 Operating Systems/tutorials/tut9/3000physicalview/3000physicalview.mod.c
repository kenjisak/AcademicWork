#include <linux/module.h>
#define INCLUDE_VERMAGIC
#include <linux/build-salt.h>
#include <linux/elfnote-lto.h>
#include <linux/vermagic.h>
#include <linux/compiler.h>

BUILD_SALT;
BUILD_LTO_INFO;

MODULE_INFO(vermagic, VERMAGIC_STRING);
MODULE_INFO(name, KBUILD_MODNAME);

__visible struct module __this_module
__section(".gnu.linkonce.this_module") = {
	.name = KBUILD_MODNAME,
	.init = init_module,
#ifdef CONFIG_MODULE_UNLOAD
	.exit = cleanup_module,
#endif
	.arch = MODULE_ARCH_INIT,
};

#ifdef CONFIG_RETPOLINE
MODULE_INFO(retpoline, "Y");
#endif

static const struct modversion_info ____versions[]
__used __section("__versions") = {
	{ 0xe49bb82b, "module_layout" },
	{ 0x9b323606, "device_destroy" },
	{ 0x6bc3fbc0, "__unregister_chrdev" },
	{ 0x41c0a893, "class_destroy" },
	{ 0xa320ad69, "class_unregister" },
	{ 0x6126cf1d, "device_create" },
	{ 0x5c7f3cc9, "__class_create" },
	{ 0x7a7b2bd8, "__register_chrdev" },
	{ 0xa648e561, "__ubsan_handle_shift_out_of_bounds" },
	{ 0x37a0cba, "kfree" },
	{ 0x6b10bee1, "_copy_to_user" },
	{ 0x7cd8d75e, "page_offset_base" },
	{ 0x4f5aee3b, "pv_ops" },
	{ 0xdad13544, "ptrs_per_p4d" },
	{ 0x8a35b432, "sme_me_mask" },
	{ 0x1d19f77b, "physical_mask" },
	{ 0xa92ec74, "boot_cpu_data" },
	{ 0x72d79d83, "pgdir_shift" },
	{ 0x66c4875a, "current_task" },
	{ 0x13c49cc2, "_copy_from_user" },
	{ 0x60f64c0d, "kmem_cache_alloc_trace" },
	{ 0x3703b5ff, "kmalloc_caches" },
	{ 0x92997ed8, "_printk" },
	{ 0x5b8239ca, "__x86_return_thunk" },
	{ 0xbdfb6dbb, "__fentry__" },
};

MODULE_INFO(depends, "");


MODULE_INFO(srcversion, "91A26BC60B0E1B9AB5AD072");
