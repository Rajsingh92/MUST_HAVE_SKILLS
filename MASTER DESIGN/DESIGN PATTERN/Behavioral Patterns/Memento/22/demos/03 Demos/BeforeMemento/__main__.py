from iheart42 import I_Heart_42
import random

def main():
    g = I_Heart_42('Arthur')

    # Show current game state
    print(f'Hero: {g.game_state.name}, Game level: {g.game_state.level}')
    saved_game = g.save_game()

    # Change the game state
    g.game_state.level = random.randint(1, 42)
    g.game_state.name = 'Ford'
    print(f'Hero: {g.game_state.name}, Game level: {g.game_state.level}')

    # Restore the old game state
    g.restore_game(saved_game)
    print(f'Hero: {g.game_state.name}, Game level: {g.game_state.level}')

if __name__ == '__main__':
    main()
