Kenji Isak Laguan
101160737

NOTES
    - all functionality works to my knowledge of the specs
    - removed most of console.log lines to declutter
    - documented as much as possible
    - Program breaks rarely when switching between pages(im pretty sure just order form) and wont display
        - hard to replicate issue, rarely happens when spamming order form links
        - made a design change to set a selectdefault to be the first vendor name if select.options[select.selectedIndex] is undefined
            - vendor can be undefined rarely too but the workaround to have a default vendor data/object stored in client might be a bit much so didnt implement it

DESIGN CHANGES/ADD ONS
    - arranged files in specific folders to clean up space, and adjusted file grabbing source handlings accordingly
    - adding total to global scope to be able to access total through other functions and send it back to server
    - added to send post request to server to update the curren vendor whenever changed
    - created homepage html file
    - edited supplied ordeform html file to include the headers for the links of pages for ease
    - included headers for pug as a partial file as requested, wasnt able to do the same for the html files

TO RUN APP
    - after extraction
    - change directories till youre within the assignment folder in terminal
    - make sure to have node.js already installed
    - install pug and dependencies with 
        - npm install pug
        - npm init --yes
    - to run the server
        - node server.js
    - go to chrome and enter either links to get to the home page
        - http://localhost:3000 
        - http://localhost:3000/
        - http://localhost:3000/home
    - play around with app functionality
        - happy marking :)