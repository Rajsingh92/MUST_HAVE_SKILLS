from sklearn.feature_extraction.text import TfidfVectorizer
from nltk.tokenize import word_tokenize
from sklearn.feature_extraction.text import CountVectorizer


def find_sentiment(sentence, pos, neg):
    """
    This function returns sentiment of sentence
    :param sentence: sentence, a string
    :param pos: set of positive words
    :param neg: set of negative words
    :return: returns positive, negative or neutral sentiment
    """

    # split sentence by a space
    # "this is a sentence!" becomes:
    # ["this", "is" "a", "sentence!"]
    # note that im splitting on all whitespaces
    # if you want to split by space use .split(" ")
    sentence = sentence.split()

    # make sentence into a set
    sentence = set(sentence)

    # check number of common words with positive
    num_common_pos = len(sentence.intersection(pos))

    # check number of common words with negative
    num_common_neg = len(sentence.intersection(neg))

    # make conditions and return
    # see how return used eliminates if else
    if num_common_pos > num_common_neg:
        return "positive"
    if num_common_pos < num_common_neg:
        return "negative"
    return "neutral"


#

