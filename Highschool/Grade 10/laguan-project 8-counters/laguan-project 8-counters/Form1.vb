Public Class Form1
    Dim button1 As Integer = 5
    Dim button2 As Integer = 0
    Dim button3 As Integer = 0

    Private Sub Label1_Click(sender As Object, e As EventArgs) Handles lblTwo.Click

    End Sub

    Private Sub lblOne_Click(sender As Object, e As EventArgs) Handles lblOne.Click

    End Sub

    Private Sub btnOne_Click(sender As Object, e As EventArgs) Handles btnAddOne.Click
        Dim btnOne As Integer = 0
        button1 = button1 + 1
        lblOne.Text = button1


    End Sub

    Private Sub btnTwo_Click(sender As Object, e As EventArgs) Handles btnAddTwo.Click
        Dim btnAddTwo As Integer = 0
        button2 = button2 + 2
        lblTwo.Text = button2

    End Sub

    Private Sub btnThree_Click(sender As Object, e As EventArgs) Handles btnAddThree.Click
        Dim btnThree As Integer = 0
        button3 = button3 + 3
        lblThree.Text = button3

    End Sub

    Private Sub btnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click
        Application.Exit()

    End Sub

    Private Sub btnMinusOne_Click(sender As Object, e As EventArgs) Handles btnMinusOne.Click
        button1 = button1 - 1
        lblOne.Text = button1

    End Sub

    Private Sub Button5_Click(sender As Object, e As EventArgs) Handles Button5.Click
        button1 = button1 - 1
        lblOne.Text = button1
    End Sub

    Private Sub Button6_Click(sender As Object, e As EventArgs) Handles Button6.Click
        lblThree.Text = Val(lblThree.Text) - 3
    End Sub
End Class

