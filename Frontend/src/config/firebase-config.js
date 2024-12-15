// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// import { getAnalytics } from "firebase/analytics";
import { getAuth, GoogleAuthProvider } from 'firebase/auth'
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyCTyxM8OygHlhNlKva6G2JSfUbk-1AT2Bo",
    authDomain: "edu-sprint-61d87.firebaseapp.com",
    projectId: "edu-sprint-61d87",
    storageBucket: "edu-sprint-61d87.firebasestorage.app",
    messagingSenderId: "221075632416",
    appId: "1:221075632416:web:0ca28fb68055066a912745",
    measurementId: "G-RSV0PLQ27E"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
// const analytics = getAnalytics(app);
const auth = getAuth(app);
const googleProvider = new GoogleAuthProvider();

export { auth, googleProvider };