//
//  ViewController.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/23.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class SignupViewController: UIViewController {
    
    @IBOutlet weak var IDTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var passwordConfirmTextField: UITextField!
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var nextButton: UIButton!
    @IBOutlet var labels: [UILabel]!
    
    @IBAction func nextButtonPushed(_ sender: UIButton) {
        let personalViewController = self.storyboard!.instantiateViewController(identifier: "PersonalInformationViewController")
        personalViewController.modalPresentationStyle = .fullScreen
        present(personalViewController, animated: true)
    }
    
    
    private let idTextFieldDelegate = IDTextFieldDelegate()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setDelegate()
    }
    
    private func setDelegate() {
        IDTextField.delegate = idTextFieldDelegate
    }
}

