#include "/home/meirelles/Clases_UA/MACHINE_LEARNING/ALE/Arcade-Learning-Environment/src/ale_interface.hpp"

ALEInterface alek;

int main(int argc, char **argv) {

	alek.setInt("random_seed", 0); // Difiere de la semilla de srand.
	alek.setFloat("repeat_action_probability", 0);
	alek.setBool("display_screen", false);
	alek.setBool("sound", false);
	alek.loadROM("/home/meirelles/Clases_UA/MACHINE_LEARNING/atari_roms_supported/demon_attack.bin");

	return 0;
}