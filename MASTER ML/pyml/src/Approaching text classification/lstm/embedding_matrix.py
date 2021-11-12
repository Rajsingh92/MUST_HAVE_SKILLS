

def load_embeddings(word_index, embedding_file, vector_length=300):
    """
    A general function to create embedding matrix
    :param word_index: word:index dictionary
    :param embedding_file: path to embeddings file
    :param vector_length: length of vector
    """
    max_features = len(word_index) + 1
    words_to_find = list(word_index.keys())
    more_words_to_find = []
    for wtf in words_to_find:
        more_words_to_find.append(wtf)
        more_words_to_find.append(str(wtf).capitalize())
    more_words_to_find = set(more_words_to_find)

    def get_coefs(word, *arr):
        return word, np.asarray(arr, dtype='float32')

    embeddings_index = dict(
        get_coefs(*o.strip().split(" "))
        for o in open(embedding_file)
        if o.split(" ")[0]
        in more_words_to_find
        and len(o) > 100
    )

    embedding_matrix = np.zeros((max_features, vector_length))
    for word, i in word_index.items():
        if i >= max_features:
            continue
    embedding_vector = embeddings_index.get(word)
    
    if embedding_vector is None:
        embedding_vector = embeddings_index.get(
            str(word).capitalize()
        )

    if embedding_vector is None:
        embedding_vector = embeddings_index.get(
            str(word).upper()
        )
        
    if (embedding_vector is not None
            and len(embedding_vector) == vector_length):
        embedding_matrix[i] = embedding_vector
    return embedding_matrix
