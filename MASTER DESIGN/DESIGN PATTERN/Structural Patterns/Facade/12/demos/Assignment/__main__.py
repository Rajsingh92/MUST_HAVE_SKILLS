from get_twitter.twitter_facade import TwitterFacade

def main():
    t = TwitterFacade()
    timelines = t.get_twitter()

    for (name, text) in timelines:
        print('User: {}, Update: {}'.format(name, text))

if __name__ == '__main__':
    main()
