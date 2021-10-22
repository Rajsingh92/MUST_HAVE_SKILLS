# api.py
import config
import flask
import time
import torch
import torch.nn as nn
from flask import Flask
from flask import request
from model import BERTBaseUncased
app = Flask(__name__)

# init model to None
MODEL = None
# choose device
DEVICE = "cuda"


def sentence_prediction(sentence):
    """
    A prediction function that takes an input sentence
    and returns the probability for it being associated
    to a positive sentiment
    """
    # fetch the tokenizer and max len of tokens from config.py
    tokenizer = config.TOKENIZER
    max_len = config.MAX_LEN
    # the processing is same as it was done for training
    review = str(sentence)
    review = " ".join(review.split())
    # encode the sentence into ids,
    # truncate to max length &
    # add CLS and SEP tokens
    inputs = tokenizer.encode_plus(
        review,
        None,
        add_special_tokens=True,
        max_length=max_len
    )
    # fetch input ids, mask & token type ids
    ids = inputs["input_ids"]
    mask = inputs["attention_mask"]
    token_type_ids = inputs["token_type_ids"]
    # add padding if needed
    padding_length = max_len - len(ids)
    ids = ids + ([0] * padding_length)
    mask = mask + ([0] * padding_length)
    token_type_ids = token_type_ids + ([0] * padding_length)
    # convert all the inputs to torch tensors
    # we use unsqueeze(0) since we have only one sample
    # this makes the batch size 1
    ids = torch.tensor(ids, dtype=torch.long).unsqueeze(0)
    mask = torch.tensor(mask, dtype=torch.long).unsqueeze(0)
    token_type_ids = torch.tensor(token_type_ids,
                                  dtype=torch.long).unsqueeze(0)
    # send everything to device
    ids = ids.to(DEVICE, dtype=torch.long)
    token_type_ids = token_type_ids.to(DEVICE, dtype=torch.long)
    mask = mask.to(DEVICE, dtype=torch.long)
    # use the model to make predictions
    outputs = MODEL(ids=ids, mask=mask, token_type_ids=token_type_ids)
    # take sigmoid of prediction and return the output
    outputs = torch.sigmoid(outputs).cpu().detach().numpy()
    return outputs[0][0]


@app.route("/predict", methods=["GET"])
def predict():

    sentence = request.args.get("sentence")

    start_time = time.time()
    
    positive_prediction = sentence_prediction(sentence)
    
    negative_prediction = 1 - positive_prediction
    
    response = {}
    response["response"] = {
        "positive": str(positive_prediction),
        "negative": str(negative_prediction),
        "sentence": str(sentence),
        "time_taken": str(time.time() - start_time),
    }
    
    return flask.jsonify(response)


if __name__ == "__main__":
    # init the model
    MODEL = BERTBaseUncased()
    # load the dictionary
    MODEL.load_state_dict(torch.load(
        config.MODEL_PATH, map_location=torch.device(DEVICE)
    ))

    # send model to device
    MODEL.to(DEVICE)

    # put model in eval mode
    MODEL.eval()
    # start the application
    # 0.0.0.0 means that this endpoint can be
    # accessed from all computers in a network
    app.run(host="0.0.0.0")
