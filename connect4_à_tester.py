# connect 4

import pygame
import random
import sys
import time

pygame.init()

# colors
white = (255, 255, 255)
black = (0, 0, 0)
red = (255, 0, 0)
green = (0, 255, 0)
blue = (0, 0, 255)
yellow = (255, 255, 0)
purple = (255, 0, 255)
cyan = (0, 255, 255)

# game window
display_width = 800
display_height = 600
gameDisplay = pygame.display.set_mode((display_width, display_height))
pygame.display.set_caption('Connect 4')
clock = pygame.time.Clock()

# images
board = pygame.image.load('board.png')
board = pygame.transform.scale(board, (display_width, display_height))
red_piece = pygame.image.load('red_piece.png')
red_piece = pygame.transform.scale(red_piece, (100, 100))
yellow_piece = pygame.image.load('yellow_piece.png')
yellow_piece = pygame.transform.scale(yellow_piece, (100, 100))

# game variables
board_width = 7
board_height = 6
board_size = board_width * board_height
board_array = [0] * board_size

# game functions
def draw_board():
    gameDisplay.blit(board, (0, 0))
    
def draw_pieces():
    for i in range(board_size):
        if board_array[i] == 1:
            gameDisplay.blit(red_piece, (100 * (i % board_width), 100 * (i // board_width)))
        elif board_array[i] == 2:
            gameDisplay.blit(yellow_piece, (100 * (i % board_width), 100 * (i // board_width)))

def check_win():
    for i in range(board_width):
        for j in range(board_height):
            if board_array[i + j * board_width] == 1:
                if i + 3 < board_width and board_array[i + 1 + j * board_width] == 1 and board_array[i + 2 + j * board_width] == 1 and board_array[i + 3 + j * board_width] == 1:
                    return 1
                if j + 3 < board_height and board_array[i + (j + 1) * board_width] == 1 and board_array[i + (j + 2) * board_width] == 1 and board_array[i + (j + 3) * board_width] == 1:
                    return 1
                if i + 3 < board_width and j + 3 < board_height and board_array[i + 1 + (j + 1) * board_width] == 1 and board_array[i + 2 + (j + 2) * board_width] == 1 and board_array[i + 3 + (j + 3) * board_width] == 1:
                    return 1
                if i - 3 >= 0 and j + 3 < board_height and board_array[i - 1 + (j + 1) * board_width] == 1 and board_array[i - 2 + (j + 2) * board_width] == 1 and board_array[i - 3 + (j + 3) * board_width] == 1:
                    return 1
            elif board_array[i + j * board_width] == 2:
                if i + 3 < board_width and board_array[i + 1 + j * board_width] == 2 and board_array[i + 2 + j * board_width] == 2 and board_array[i + 3 + j * board_width] == 2:
                    return 2
                if j + 3 < board_height and board_array[i + (j + 1) * board_width] == 2 and board_array[i + (j + 2) * board_width] == 2 and board_array[i + (j + 3) * board_width] == 2:
                    return 2
                if i + 3 < board_width and j + 3 < board_height and board_array[i + 1 + (j + 1) * board_width] == 2 and board_array[i + 2 + (j + 2) * board_width] == 2 and board_array[i + 3 + (j + 3) * board_width] == 2:
                    return 2
                if i - 3 >= 0 and j + 3 < board_height and board_array[i - 1 + (j + 1) * board_width] == 2 and board_array[i - 2 + (j + 2) * board_width] == 2 and board_array[i - 3 + (j + 3) * board_width] == 2:
                    return 2
    return 0

def check_tie():
    for i in range(board_size):
        if board_array[i] == 0:
            return 0
    return 1

def game_loop():
    gameExit = False
    player = 1
    while not gameExit:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
            if event.type == pygame.MOUSEBUTTONDOWN:
                mouse_x, mouse_y = pygame.mouse.get_pos()
                for i in range(board_width):
                    if mouse_x > i * 100 and mouse_x < (i + 1) * 100:
                        for j in range(board_height):
                            if board_array[i + j * board_width] == 0:
                                board_array[i + j * board_width] = player
                                if player == 1:
                                    player = 2
                                else:
                                    player = 1
                                break
        gameDisplay.fill(white)
        draw_board()
        draw_pieces()
        if check_win() == 1:
            gameDisplay.fill(red)
            pygame.display.update()
            time.sleep(2)
            game_loop()
        elif check_win() == 2:
            gameDisplay.fill(yellow)
            pygame.display.update()
            time.sleep(2)
            game_loop()
        elif check_tie() == 1:
            gameDisplay.fill(black)
            pygame.display.update()
            time.sleep(2)
            game_loop()
        pygame.display.update()
        clock.tick(60)

game_loop()
pygame.quit()
quit()

