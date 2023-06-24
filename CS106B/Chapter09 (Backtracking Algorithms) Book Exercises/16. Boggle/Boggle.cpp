/*
 * File: main.cpp
 * --------------
 * The game of Boggle is played with a 4!4 grid of cubes, each of which shows a letter on its face. The goal
 * is to form as many words of four or more letters as possible, moving only between letter cubes that are
 * adjacent—horizontally, vertically, or diagonally—never using any cube more than once. Figure 9-9 shows
 * a possible Boggle layout and the words in the EnglishWords.dat lexicon that you can find from that starting
 * position. As an example, you can form the word programming using the following sequence of cubes:
 *
 * Write a function
 *
 *            void findBoggleWords(const Grid<char> & board,
 *                                const Lexicon & english,
 *                                Vector<string> & wordsFound);
 *
 * that finds all the legal words on the board that appear in the english lexicon and adds those words to the vector wordsFound.
 */

#include "console.h"
#include "simpio.h"
#include "grid.h"
#include "vector.h"
#include "lexicon.h"
#include "strlib.h"

using namespace std;


int const MIN_LEGHT = 4;

void printListOfWords(Vector<string> wordsFound);
string titleCase(string A);
bool isLegal(GPoint dest, Grid<char> board, Set<GPoint> usedCubes);
GPoint travel(GPoint start, int var);
int maxLenght(Lexicon english);
void findBoggleWords(const Grid<char> & board, const Lexicon & english, Vector<string> & wordsFound);
void wordSearch(const Grid<char> & board, const Lexicon & english, Set<GPoint> & usedCubes, Vector<string> & wordsFound, GPoint start, string candidate, int maxLenght);



int main() {
    Lexicon english("EnglishWords.txt");
    Grid<char> board {{'X', 'C', 'E', 'R'}, {'I', 'M', 'G', 'A'}, {'N', 'O', 'M', 'L'}, {'G', 'Z', 'R', 'P'}};
    Vector<string> wordsFound;
    findBoggleWords(board, english, wordsFound);
    printListOfWords(wordsFound);

    return 0;
}


/* Recursive functions
 * ---------------------------------------------------------------------------------------
 */

void wordSearch(const Grid<char> & board, const Lexicon & english, Set<GPoint> & usedCubes, Vector<string> & wordsFound, GPoint start, string candidate, int maxLenght){
    if (maxLenght == 0);
    else {
        GPoint dest;
        char startBox = board[start.x][start.y];
        candidate += startBox;
        if (candidate.size() >= MIN_LEGHT && english.contains(candidate)) {
            wordsFound.add(candidate);
        }
        for (int var = 1; var < 9; ++var) {
            dest = travel(start, var);
            if (isLegal(dest, board, usedCubes)) {
                usedCubes.add(start);
                if (english.containsPrefix(candidate + board[dest.x][dest.y])) {
                    wordSearch(board, english, usedCubes, wordsFound, dest, candidate, maxLenght--);
                }
            }
        }
    }
    usedCubes.clear();
}


void findBoggleWords(const Grid<char> & board, const Lexicon & english, Vector<string> & wordsFound){
    string candidate;
    Set<GPoint> usedCubes;

    for (int y = 0; y < board.numRows(); ++y) {
        for (int x = 0; x < board.numCols(); ++x) {
        GPoint start(x,y);
        wordSearch(board, english, usedCubes, wordsFound, start, candidate, maxLenght(english));
        candidate.clear();
        }
    }
   wordsFound.sort();
}


/* Helper functions
 * ---------------------------------------------------------------------------------------
 */

int maxLenght(Lexicon english) {
    int max = 0;
    for (string s : english) {
        if (max == 0) max = s.size();
        if (s.size() > max) max = s.size();
    }
    return max;
}



/* Moving functions
 * ---------------------------------------------------------------------------------------
 */

    GPoint travel(GPoint start, int var){
        GPoint result = start;
        switch (var) {
            case 1:
                result.y -= 1;
                break;
            case 2:
                result.y -= 1;
                result.x += 1;
                break;
            case 3:
                result.x += 1;
                break;
            case 4:
                result.x += 1;
                result.y += 1;
                break;
            case 5:
                result.y += 1;
                break;
            case 6:
                result.y += 1;
                result.x -= 1;
                break;
            case 7:
                result.x -= 1;
                break;
            case 8:
                result.y -= 1;
                result.x -= 1;
                break;
        }
        return result;
    }


    bool isLegal(GPoint dest, Grid<char> board, Set<GPoint> usedCubes){
        if (board.inBounds(dest.y, dest.x) && !usedCubes.contains(dest)) return true;
        return false;
    }


/* Printer functions
 * ---------------------------------------------------------------------------------------
 */

    string titleCase(string A){
        string result = std::to_string(A[0]);
        result += toLowerCase(A.substr(1));
        return result;
    }

    void printListOfWords(Vector<string> wordsFound) {
        Set<string> helper;
        for (string s : wordsFound) {
            if (!helper.contains(s)) cout << titleCase(s) << endl;
            helper.add(s);
        }
    }


