#include "/home/meirelles/Clases_UA/MACHINE_LEARNING/ALE/Arcade-Learning-Environment/src/ale_interface.hpp"

ALEInterface ale;

ale.setInt("random_seed", 0); // Difiere de la semilla de srand.
ale.setFloat("repeat_action_probability", 0);
ale.setBool("display_screen", false);
ale.setBool("sound", false);
ale.loadROM("/home/meirelles/Clases_UA/MACHINE_LEARNING/atari_roms_supported/demon_attack.bin");
